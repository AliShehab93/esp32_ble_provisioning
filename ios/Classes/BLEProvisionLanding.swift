// Copyright 2020 Espressif Systems (Shanghai) PTE LTD
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
// Copyright 2021 Ali Shehab ali.h.shehab93@gmail.com
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
//  BLEProvisionLanding.swift
//  esp32_ble_provisioning_plugin
//
//  Created by Ali Shehab on 26/01/2021.
//


import CoreBluetooth
import Foundation
import MBProgressHUD
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
                if(bleDevices != nil){
                    self.bleDevices = bleDevices!
                }else{
                    self.bleDevices = []
                }

                for device in self.bleDevices {
                    self.bleDevicesNames.append(device.name)
                }
                /// adding the ble devices names to stream
                if let controller = SwiftStreamBleDevicesAvailable.eventSinkDevicesAvailable {
                    controller(self.bleDevicesNames)
                }
            }
        }
    }
}
