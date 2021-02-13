
import 'dart:async';

import 'package:flutter/services.dart';

class Esp32BleProvisioning {
  static const MethodChannel _channel =
      const MethodChannel('esp32_ble_provisioning');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
}
