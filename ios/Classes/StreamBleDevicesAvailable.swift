//
//  StreamBleDevicesAvailable.swift
//  esp32_ble_provisioning_plugin
//
//  Created by Ali Shehab on 26/01/2021.
//

import Foundation

/// Stream class to send the available ble devices to  flutter
class SwiftStreamBleDevicesAvailable: NSObject, FlutterStreamHandler {
    
    static var eventSinkDevicesAvailable: FlutterEventSink?
  
    public func onListen(withArguments arguments: Any?, eventSink events: @escaping FlutterEventSink) -> FlutterError? {
        SwiftStreamBleDevicesAvailable.eventSinkDevicesAvailable = events
        // any generic type or more compex dictionary of [String:Any]
//        events(FlutterError(code: "ERROR_CODE",
//                             message: "Detailed message",
//                             details: nil)) // in case of errors
//        events(FlutterEndOfEventStream) // when stream is over
        return nil
    }

    public func onCancel(withArguments arguments: Any?) -> FlutterError? {
        return nil
    }
}
