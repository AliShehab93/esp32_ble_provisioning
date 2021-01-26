#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html.
# Run `pod lib lint esp32_ble_provisioning_plugin.podspec' to validate before publishing.
#
Pod::Spec.new do |s|
  s.name             = 'esp32_ble_provisioning_plugin'
  s.version          = '0.0.1'
  s.summary          = 'An esp32 ble provisioning plugin'
  s.description      = <<-DESC
An esp32 ble provisioning plugin
                       DESC
  s.homepage         = 'http://example.com'
  s.license          = { :file => '../LICENSE' }
  s.author           = { 'Ali Shehab' => 'ali.h.shehab93@gmail.com' }
  s.source           = { :path => '.' }
  s.source_files = 'Classes/**/*'
  s.dependency 'Flutter'
  s.platform = :ios, '11.0'
  s.dependency 'ESPProvision'
  s.dependency 'MBProgressHUD'

  # Flutter.framework does not contain a i386 slice.
  s.pod_target_xcconfig = { 'DEFINES_MODULE' => 'YES', 'EXCLUDED_ARCHS[sdk=iphonesimulator*]' => 'i386' }
  s.swift_version = '5.0'
end
