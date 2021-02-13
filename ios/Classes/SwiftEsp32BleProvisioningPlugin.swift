//
//  SwiftEsp32BleProvisioningPlugin.swift
//  esp32_ble_provisioning_plugin
//
//  Created by Ali Shehab on 26/01/2021.
//

import Flutter
import UIKit

public class SwiftEsp32BleProvisioningPlugin: NSObject, FlutterPlugin {

  /// variable for BLEProvisionLanding class
  static var ble: BLEProvisionLanding?
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "esp32_ble_provisioning", binaryMessenger: registrar.messenger())
    let instance = SwiftEsp32BleProvisioningPlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)

    /// initializing ble
    ble = BLEProvisionLanding()

    /// creating the stream to listen to available devices
    let availableBleDevicesChannel = FlutterEventChannel(name: "available_ble_devices_stream", binaryMessenger:registrar.messenger())
    availableBleDevicesChannel.setStreamHandler(SwiftStreamBleDevicesAvailable())

    /// creating the stream to listen to device connect states
    let connectToBleDeviceChannel = FlutterEventChannel(name: "connecting_to_device_stream", binaryMessenger:registrar.messenger())
    connectToBleDeviceChannel.setStreamHandler(SwiftStreamBleDeviceConnect())
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    /// method to search for available ble devices
        if(call.method == "searchForBleDevices"){
            SwiftEsp32BleProvisioningPlugin.ble?.searchForBleDevices()
        }
    /// method  to connect to device
        else if(call.method == "connectToDevice") {
            guard let args = call.arguments else {
                return result("iOS could not recognize flutter arguments in method: (sendParams)")
            }

            if let myArgs = args as? [String: String],
                let deviceName = myArgs["deviceName"],
                let securityKey = myArgs["securityKey"],
                let ssid = myArgs["ssid"],
                let password = myArgs["password"] {
                let bleDeveiceConnect = BLEProvisionDeviceConnect()
                bleDeveiceConnect.connectToDevice(bleDevices: SwiftEsp32BleProvisioningPlugin.ble?.bleDevices ?? [], deviceName: deviceName, securityKey: securityKey, ssid: ssid, password: password)
                } else {
                    result(FlutterError(code: "-1", message: "iOS could not extract " +
                    "flutter arguments in method: (sendParams)", details: nil))
                }
        }else{
            result("iOS " + UIDevice.current.systemVersion)
        }
  }
}
