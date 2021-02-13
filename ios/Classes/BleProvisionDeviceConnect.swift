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
//  BleProvisionDeviceConnect.swift
//  esp32_ble_provisioning_plugin
//
//  Created by Ali Shehab on 26/01/2021.
//


import Foundation

public class BLEProvisionDeviceConnect: UIViewController  {
    
    var espDevice: ESPDevice!
    var pop = ""
    
    public func connectToDevice (bleDevices: Array<ESPDevice>, deviceName: String, securityKey: String, ssid: String, password: String) {
        
        pop = securityKey
        
        /// searching for  the selected device
        for device in bleDevices {
            if(device.name == deviceName){
                /// now need to connect to the selected device
                espDevice = device
                espDevice.connect(delegate: self) { status in
                    DispatchQueue.main.async {
                        switch status {
                        case .connected:
                            if let controller = SwiftStreamBleDeviceConnect.eventSinkDeviceConnect {
                                controller("deviceConnected")
                            }
                            /// complete connecting to device by sending the wifi ssid and password and trying to provision to device
                            self.espDevice.provision(ssid: ssid, passPhrase: password) { status in
                                DispatchQueue.main.async {
                                    switch status {
                                    case .success:
                                        if let controller = SwiftStreamBleDeviceConnect.eventSinkDeviceConnect {
                                            controller("provisioninSuccess")
                                        }
                                    case .failure(_):
                                        if let controller = SwiftStreamBleDeviceConnect.eventSinkDeviceConnect {
                                            controller("onProvisioninFailed")
                                        }
//                                        switch error {
//                                        case .configurationError:
//                                            self.step1FailedWithMessage(message: "Failed to apply network                                                           configuration to device")
//                                        case .sessionError:
//                                            self.step1FailedWithMessage(message: "Session is not                                                                    established")
//                                        case .wifiStatusDisconnected:
//                                            self.step2FailedWithMessage(error: error)
//                                        default:
//                                            self.step2FailedWithMessage(error: error)
//                                        }
                                    case .configApplied:
                                        if let controller = SwiftStreamBleDeviceConnect.eventSinkDeviceConnect {
                                            controller("wifiConfigSent")
                                            controller("wifiConfigApplied")
                                        }
                                    }
                                }
                            }
                        case .failedToConnect(_):
                            if let controller = SwiftStreamBleDeviceConnect.eventSinkDeviceConnect {
                                controller("failedToConnectToDevice")
                            }
                        default:
                            let action = UIAlertAction(title: "Retry", style: .default, handler: nil)
                            self.showAlert(error: "Device disconnected", action: action)
                            if let controller = SwiftStreamBleDeviceConnect.eventSinkDeviceConnect {
                                controller("failedToConnectToDevice")
                            }
                        }
                    }
                }
              break
            }
        }
    }
    
    func showAlert(error: String, action: UIAlertAction) {
        let alertController = UIAlertController(title: "Error!", message: error, preferredStyle: .alert)
        alertController.addAction(action)
        present(alertController, animated: true, completion: nil)
    }
    
}

/// this is used by connecting the device by taking the security key by this function
extension BLEProvisionDeviceConnect: ESPDeviceConnectionDelegate {
    public func getProofOfPossesion(forDevice _: ESPDevice) -> String? {
        return pop
    }
}
