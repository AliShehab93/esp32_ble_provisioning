//
//  BleProvisionDeviceConnect.swift
//  esp32_ble_provisioning_plugin
//
//  Created by Ali Shehab on 26/01/2021.
//


import Foundation
import ESPProvision

public class BLEProvisionDeviceConnect: UIViewController  {
    
    var espDevice: ESPDevice!
    var pop = ""
    
    public func connectToDevice (bleDevices: Array<ESPDevice>, deviceName: String, securityKey: String, ssid: String, password: String) {
      print("bleDevices:::: ",bleDevices)
        
        print("in connectt deviceName areee:  ",deviceName)
        print("in connectt securityKey areee:  ",securityKey)
        print("in connectt ssid areee:  ",ssid)
        print("in connectt password areee:  ",password)
        
        pop = securityKey
        var securityMode:ESPSecurity
        
        /// searching for  the selected device
        for device in bleDevices {
            print("device  is:: ", device.name)
            if(device.name == deviceName){
                print("Founddd my deviceeeeee   ", device.name, device.security)
                /// now need to connect to the selected device
                espDevice = device
                espDevice.connect(delegate: self) { status in
                    DispatchQueue.main.async {
                        switch status {
                        case .connected:
                            print("conecteddddddd HEYYYY()()()()()()( my deviceeeeee   ")
                            if let controller = SwiftStreamBleDeviceConnect.eventSinkDeviceConnect {
                                controller("deviceConnected")
                            }
                            /// complete connecting to device by sending the wifi ssid and password and trying to provision to device
                            self.espDevice.provision(ssid: ssid, passPhrase: password) { status in
                                DispatchQueue.main.async {
                                    switch status {
                                    case .success:
                                        print("Device has been successfully provisioned!")
                                        if let controller = SwiftStreamBleDeviceConnect.eventSinkDeviceConnect {
                                            controller("provisioninSuccess")
                                        }
                                    case let .failure(error):
                                        print("ERRoorrr provisoionggg")
                                        if let controller = SwiftStreamBleDeviceConnect.eventSinkDeviceConnect {
                                            controller("onProvisioninFailed")
                                        }
                                        
//                                        switch error {
//                                        case .configurationError:
//                                            self.step1FailedWithMessage(message: "Failed to apply network                                         configuration to device")
//                                        case .sessionError:
//                                            self.step1FailedWithMessage(message: "Session is not                                                      established")
//                                        case .wifiStatusDisconnected:
//                                            self.step2FailedWithMessage(error: error)
//                                        default:
//                                            self.step2FailedWithMessage(error: error)
//                                        }
                                    case .configApplied:
                                        print("Config sent and applied successfully")
                                        if let controller = SwiftStreamBleDeviceConnect.eventSinkDeviceConnect {
                                            controller("wifiConfigSent")
                                            controller("wifiConfigApplied")
                                        }
                                    }
                                }
                            }
                        case let .failedToConnect(error):
                            print("failed to connect   ", error)
                            if let controller = SwiftStreamBleDeviceConnect.eventSinkDeviceConnect {
                                controller("failedToConnectToDevice")
                            }
                        default:
                            let action = UIAlertAction(title: "Retry", style: .default, handler: nil)
                            self.showAlert(error: "Device disconnected", action: action)
                            print("default nfailed to connect   ")
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

