//
//  StreamBleDeviceConnect.swift
//  esp32_ble_provisioning_plugin
//
//  Created by Ali Shehab on 26/01/2021.
//

import Foundation

/// Stream class to send the status of connection to device to  flutter
class SwiftStreamBleDeviceConnect: NSObject, FlutterStreamHandler {
    
    static var eventSinkDeviceConnect: FlutterEventSink?

    public func onListen(withArguments arguments: Any?, eventSink events: @escaping FlutterEventSink) -> FlutterError? {
        SwiftStreamBleDeviceConnect.eventSinkDeviceConnect = events
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
