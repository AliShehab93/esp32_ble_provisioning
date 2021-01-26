
import 'dart:async';

import 'package:flutter/services.dart';

typedef void Listener(dynamic msg);
typedef void CancelListening();


class Esp32BleProvisioningPlugin {
  static const MethodChannel _channel =
      const MethodChannel('esp32_ble_provisioning_plugin');
  static const _eventChannel = const EventChannel('connecting_to_device_stream');
  static const _availableBleDevicesChannel = const EventChannel('available_ble_devices_stream');

  /// this method is used by both platforms [ Android - ios ]
  /// to get available devices
  static void searchForAvailableDevices(Listener listener) async {
    _availableBleDevicesChannel.receiveBroadcastStream().listen(listener, cancelOnError: true);
    _channel.invokeMethod('searchForBleDevices');
  }

  /// this method is used by both platforms [ Android - ios ]
  /// result returned can be:
  /// 1. deviceConnected -- success
  /// 2. deviceDisConnected -- failed
  /// 3. failedToConnectToDevice -- failed
  /// 4. createSessionFailed -- failed
  /// 5. wifiConfigSent -- success
  /// 6. wifiConfigFailed -- failed
  /// 7. wifiConfigApplied -- success
  /// 8. wifiConfigAppliedFailed -- failed
  /// 9. provisioninFailedFromDevice_AUTH_FAILED -- failed
  /// 10. provisioninFailedFromDevice_NETWORK_NOT_FOUND -- failed
  /// 11. provisioninFailedFromDevice_UNKNOWN -- failed
  /// 12. provisioninSuccess -- success
  /// 13. onProvisioninFailed -- failed
  static void connectToDevice(Listener listener,
      {String deviceName,
        String securityKey,
        String ssid,
        String password}) {
    print('before begin ');
    _eventChannel.receiveBroadcastStream().listen(listener, cancelOnError: true);
    _channel.invokeMethod('connectToDevice',
        {
          "deviceName": deviceName,
          "securityKey": securityKey,
          "ssid": ssid,
          "password":password
        });
  }

}
