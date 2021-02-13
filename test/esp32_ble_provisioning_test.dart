import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:esp32_ble_provisioning/esp32_ble_provisioning.dart';

void main() {
  const MethodChannel channel = MethodChannel('esp32_ble_provisioning');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await Esp32BleProvisioning.platformVersion, '42');
  });
}
