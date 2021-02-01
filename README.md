# esp32_ble_provisioning

An esp32 ble provisioning plugin supported for both platforms [android - ios].
This plugin works on provisioning to devices by bluetooth only.
Wi-fi provisioning is not supported.

## Getting Started
###### This plugin is supported for both android and ios platforms

## Ios integration:
###### Need to add NSBluetoothAlwaysUsageDescription in info.plist file in the project/ios directopry
###### Assign minimum platform version to 11
###### For making all your packages in your project have minimum version to 11 you can add this code to your podfile
post_install do |installer|
  installer.pods_project.targets.each do |target|
    flutter_additional_ios_build_settings(target)
        target.build_configurations.each do |config|
            config.build_settings['IPHONEOS_DEPLOYMENT_TARGET'] = '11.0'
        end
  end
end
## Android integration:
###### Need to add minSdkVersion 24 in app/gradle