//
//  BLEProvisionLanding.swift
//  esp32_ble_provisioning_plugin
//
//  Created by Ali Shehab on 26/01/2021.
//


import CoreBluetooth
import Foundation
import MBProgressHUD
import ESPProvision
import Foundation
import UIKit

protocol BLEStatusProtocol {
    func peripheralDisconnected()
}

/// This class to to search for the available ble devices
public class BLEProvisionLanding {
    var bleDevices:[ESPDevice] = []
    var bleDevicesNames:[String] = []
    
    /// search for available ble devices
  public func searchForBleDevices () {
    scanBleDevices()
  }
    
    /// start scannning
    func scanBleDevices() {
        self.bleDevices = []
        self.bleDevicesNames = []
        
        ESPProvisionManager.shared.searchESPDevices(devicePrefix: "", transport: .ble) { bleDevices, error in
            DispatchQueue.main.async {
                self.bleDevices = bleDevices!
                print("Hello, world! HEYYYYYYYYY  self.bleDevices  ==  ",bleDevices!)
                
                for device in self.bleDevices {
                    print("device  is:: ", device.name)
                    self.bleDevicesNames.append(device.name)
                }
                /// adding the ble devices names to stream
                if let controller = SwiftStreamBleDevicesAvailable.eventSinkDevicesAvailable {
                    controller(self.bleDevicesNames)
                }
                print("self.bleDevicesNames  ==  ",self.bleDevicesNames)
            }
        }
    }
}
