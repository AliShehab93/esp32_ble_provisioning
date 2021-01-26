#import "Esp32BleProvisioningPlugin.h"
#if __has_include(<esp32_ble_provisioning_plugin/esp32_ble_provisioning_plugin-Swift.h>)
#import <esp32_ble_provisioning_plugin/esp32_ble_provisioning_plugin-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "esp32_ble_provisioning_plugin-Swift.h"
#endif

@implementation Esp32BleProvisioningPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftEsp32BleProvisioningPlugin registerWithRegistrar:registrar];
}
@end
