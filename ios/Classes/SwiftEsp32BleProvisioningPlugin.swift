import Flutter
import UIKit

public class SwiftEsp32BleProvisioningPlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "esp32_ble_provisioning", binaryMessenger: registrar.messenger())
    let instance = SwiftEsp32BleProvisioningPlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    result("iOS " + UIDevice.current.systemVersion)
  }
}
