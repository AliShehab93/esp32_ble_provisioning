package com.ash93.esp32_ble_provisioning_plugin;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.EventChannel;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.ash93.esp32_ble_provisioning_plugin.BLEProvisionLanding;

import io.flutter.embedding.engine.plugins.activity.ActivityAware;


/** Esp32BleProvisioningPlugin */
public class Esp32BleProvisioningPlugin implements FlutterPlugin, MethodCallHandler, ActivityAware{
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;
  static Activity context;
  static BLEProvisionLanding bLEProvisionLanding;
  static EventChannel eventChannel;
  static EventChannel eventChannelAvailableDevices;
  static public EventChannel.EventSink emitter;
  static public EventChannel.EventSink emitterAvailableDevices;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "esp32_ble_provisioning_plugin");
    channel.setMethodCallHandler(this);

    System.out.println("onAttachedToEngine withhh");

    /// stream for available devices
    eventChannelAvailableDevices = new EventChannel(flutterPluginBinding.getBinaryMessenger(), "available_ble_devices_stream");
    eventChannelAvailableDevices.setStreamHandler(new EventChannel.StreamHandler() {
      @Override
      public void onListen(Object listener,final EventChannel.EventSink eventSink) {
        emitterAvailableDevices = eventSink;
      }

      @Override
      public void onCancel(Object arguments) {
        System.out.println("stream is cancellledddddd   ");

      }
    });

    /// stream for connecting for device
    eventChannel = new EventChannel(flutterPluginBinding.getBinaryMessenger(), "connecting_to_device_stream");
    eventChannel.setStreamHandler(new EventChannel.StreamHandler() {
      @Override
      public void onListen(Object listener,final EventChannel.EventSink eventSink) {
        emitter = eventSink;
      }

      @Override
      public void onCancel(Object arguments) {
        System.out.println("stream is cancellledddddd   ");

      }
    });
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result resulting) {
    final Result result = resulting;
    if (call.method.equals("searchForBleDevices")) {
      if (ContextCompat.checkSelfPermission(context,
              Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
        System.out.println("No location permission ");
        emitterAvailableDevices.success("No location permission");
        if (ActivityCompat.shouldShowRequestPermissionRationale(context,
                Manifest.permission.ACCESS_FINE_LOCATION)){
          ActivityCompat.requestPermissions(context,
                  new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }else{
          ActivityCompat.requestPermissions(context,
                  new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
      }else{
        System.out.println("Granted location permission ");
        bLEProvisionLanding.searchForBleDevices();
      }
    } else if (call.method.equals("connectToDevice")) {
      System.out.println("begin 0 ");
      final String deviceName = call.argument("deviceName");
      final String securityKey = call.argument("securityKey");
      final String ssid = call.argument("ssid");
      final String password = call.argument("password");

      System.out.println("ffffaaaaaa     deviceName "+deviceName);
      System.out.println("securityKey "+securityKey);
      System.out.println("ssid "+ssid);
      System.out.println("password "+password);
      System.out.println("Granted location permission ");
      bLEProvisionLanding.tryingToConnectToDevice(deviceName, securityKey, ssid, password);
      System.out.println("connect to device starteddddd ");
    } else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }

  @Override
  public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
    this.context = binding.getActivity();
    this.bLEProvisionLanding = new BLEProvisionLanding();
    this.bLEProvisionLanding.initializeBleProvisionLanding(context);
    System.out.println("pluginn constructor");
  }

  @Override
  public void onDetachedFromActivityForConfigChanges() {

  }

  @Override
  public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {

  }

  @Override
  public void onDetachedFromActivity() {

  }

  public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                         int[] grantResults){
    switch (requestCode){
      case 1: {
        if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
          if (ContextCompat.checkSelfPermission(context,
                  Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
            Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show();
          }
        }else{
          Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
        return;
      }
    }
  }
}
