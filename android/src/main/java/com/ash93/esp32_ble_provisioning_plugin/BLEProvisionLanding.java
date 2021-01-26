// Copyright 2020 Espressif Systems (Shanghai) PTE LTD
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

//package android.src.main.java.com.ash93.esp32_ble_provisioning_plugin;
package com.ash93.esp32_ble_provisioning_plugin;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.espressif.provisioning.ESPDevice;
import com.espressif.provisioning.listeners.ProvisionListener;

import com.espressif.provisioning.DeviceConnectionEvent;
import com.espressif.provisioning.ESPConstants;
import com.espressif.provisioning.ESPProvisionManager;
import com.espressif.provisioning.listeners.BleScanListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class BLEProvisionLanding {

    private static final String TAG = BLEProvisionLanding.class.getSimpleName();

    // Request codes
    private static final int REQUEST_ENABLE_BT = 1;
    private static final int REQUEST_FINE_LOCATION = 2;

    private BluetoothAdapter bleAdapter;
    private static ArrayList<BluetoothDevice> deviceList;
    private static HashMap<BluetoothDevice, String> bluetoothDevices;
    private SharedPreferences sharedPreferences;
    private Handler handler;

    private int position = -1;
    private String deviceNamePrefix;
    private ESPProvisionManager provisionManager;
    private int securityType;

    Activity activity;
    ESPDevice espDevice;
    String securityKey;
    String ssid;
    String password;
    ArrayList<String> returnedDevicesNames = new ArrayList<String>();

     static EventBus eventBus;

    @SuppressLint("MissingPermission")
    public void initializeBleProvisionLanding(Activity activity) {
        this.activity = activity;

        System.out.println("heyyyy fitnnaaaaaa 111");

        // Use this check to determine whether BLE is supported on the device.  Then you can
        // selectively disable BLE-related features.
        if (!activity.getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Toast.makeText(activity, "R.string.error_ble_not_supported", Toast.LENGTH_SHORT).show();
            activity.finish();
        }

        /// initialize the bleutooth manager
        final BluetoothManager bluetoothManager = (BluetoothManager) activity.getSystemService(Context.BLUETOOTH_SERVICE);
        bleAdapter = bluetoothManager.getAdapter();


        // Checks if Bluetooth is supported on the device.
        if (bleAdapter == null) {
            Toast.makeText(activity, "R.string.error_bluetooth_not_supported", Toast.LENGTH_SHORT).show();
            activity.finish();
        }
        System.out.println("heyyyy fitnnaaaaaa 3333");

        handler = new Handler();
        bluetoothDevices = new HashMap<>();
        Collection<BluetoothDevice> keySet = bluetoothDevices.keySet();
        deviceList = new ArrayList<>(keySet);
        securityKey = "";
        ssid = "";
        password = "";

        provisionManager = ESPProvisionManager.getInstance(activity);
        sharedPreferences = activity.getSharedPreferences(AppConstants.ESP_PREFERENCES, Context.MODE_PRIVATE);
        deviceNamePrefix = "";
        eventBus.getDefault().register(this);
        System.out.println("heyyyy fitnnaaaaaa 4444");
        System.out.println("NOWW BEGINNNNNN ########################  00000 -- create device");
        final String deviceType = sharedPreferences.getString(AppConstants.KEY_DEVICE_TYPES, AppConstants.DEVICE_TYPE_BLE);
        final boolean isSec1 = sharedPreferences.getBoolean(AppConstants.KEY_SECURITY_TYPE, true);
        Log.d(TAG, "Device Types : " + deviceType);
        Log.d(TAG, "isSec1 : " + isSec1);
        if (isSec1) {
            securityType = 1;
        }
    }

    public void searchForBleDevices() {
        /// this function searches for available ble devices if location permission is granted
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            System.out.println("NOWW BEGINNNNNN ########################  00000 -- searching for devices device");
            provisionManager.searchBleEspDevices(deviceNamePrefix, bleScanListener);
            System.out.println("heyye hala2 huneee");
        } else {
            Log.e(TAG, "Not able to start scan as Location permission is not granted.");
            Toast.makeText(activity, "Please give location permission to start BLE scan", Toast.LENGTH_LONG).show();
        }
        System.out.println("heyyyy fitnnaaaaaa 55555");
    }




    private BleScanListener bleScanListener = new BleScanListener() {

        @Override
        public void scanStartFailed() {
            Toast.makeText(activity, "Please turn on Bluetooth to connect BLE device", Toast.LENGTH_SHORT).show();
        }

        @SuppressLint("MissingPermission")
        @Override
        public void onPeripheralFound(BluetoothDevice device, ScanResult scanResult) {
            Log.d(TAG, "====== onPeripheralFound ===== " + device.getName());
            boolean deviceExists = false;
            String serviceUuid = "";

            if (scanResult.getScanRecord().getServiceUuids() != null && scanResult.getScanRecord().getServiceUuids().size() > 0) {
                serviceUuid = scanResult.getScanRecord().getServiceUuids().get(0).toString();
            }
            Log.d(TAG, "Add service UUID : " + serviceUuid);

            if (bluetoothDevices.containsKey(device)) {
                deviceExists = true;
            }

            if (!deviceExists) {
//                listView.setVisibility(View.VISIBLE);
                bluetoothDevices.put(device, serviceUuid);
                deviceList.add(device);
                returnedDevicesNames.add(device.getName());

                System.out.println("device isss:::   "+device.getAddress()   + " --- "+device.getName()   + " --- "+device.getAddress()   + " --- ");
                System.out.println("deviceList  isss:::   "+deviceList);
            }
        }

        @Override
        public void scanCompleted() {
            Esp32BleProvisioningPlugin.emitterAvailableDevices.success(returnedDevicesNames);
        }

        @Override
        public void onFailure(Exception e) {
            Log.e(TAG, e.getMessage());
            e.printStackTrace();
        }
    };


    public void tryingToConnectToDevice(String deviceName, String securityKey, String ssid, String password){
        this.securityKey = securityKey;
        this.ssid = ssid;
        this.password = password;
        provisionManager = ESPProvisionManager.getInstance(activity);
        espDevice = provisionManager.createESPDevice(ESPConstants.TransportType.TRANSPORT_BLE, ESPConstants.SecurityType.SECURITY_1);

        System.out.println("NOWW BEGINNNNNN ######################## provisionManager "+provisionManager);
        System.out.println("NOWW BEGINNNNNN ######################## espDevice        "+espDevice);
        System.out.println("NOWW BEGINNNNNN ########################  11111 -- connect to device");

        System.out.println("VVV 00 @@ securityKey "+this.securityKey);
        System.out.println("VVV 00 @@ssid "+this.ssid);
        System.out.println("VVV 00 @@ password "+this.password);

        System.out.println("deviceList.size() -- "+deviceList.size());
        System.out.println("deviceList.size() -- ");

        System.out.println("beforeee   fattt inn loooooop  0");
        System.out.println("beforeee   fattt inn loooooop  1");
        System.out.println("beforeee   fattt inn loooooop  2");
        System.out.println("beforeee   fattt inn loooooop  3");
        System.out.println("beforeee   fattt inn loooooop  4");
        System.out.println("beforeee   fattt inn loooooop  5");
        System.out.println("beforeee   fattt inn loooooop  6");
        System.out.println("beforeee   fattt inn loooooop  7");


        for (int i = 0; i < deviceList.size(); i++) {
            System.out.println("bluetoothDevices   isss i  "+deviceList.get(i).getName());
            if(deviceList.get(i).getName().equals(deviceName)){
                System.out.println("now fatttt To staerrr 000");
                BluetoothDevice provDevice = deviceList.get(i);
                System.out.println("now fatttt To staerrr 111");
                String uuid = bluetoothDevices.get(provDevice);
                System.out.println("now fatttt To staerrr 222");
                Log.d(TAG, "=================== Connect to provDevice : " + provDevice.getName() + " UUID : " + uuid);

                if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                    System.out.println("NOWW Trying to connecttt  !!!!!!!!!!!!!! ");

                    System.out.println("now begin toi connect");
                    espDevice.connectBLEDevice(provDevice, uuid);
                    System.out.println("it should be connected");
                } else {
                    Log.e(TAG, "Not able to connect provDevice as Location permission is not granted.");
                    Toast.makeText(activity, "Please give location permission to connect provDevice", Toast.LENGTH_LONG).show();
                }
            }
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(DeviceConnectionEvent event) {
        System.out.println("fatititititi in eventttttttt");

        System.out.println("VVV securityKey "+securityKey);
        System.out.println("VVV ssid "+ssid);
        System.out.println("VVV password "+password);

        Log.d(TAG, "ON Device Prov Event RECEIVED : " + event.getEventType());
        switch (event.getEventType()) {
            case ESPConstants.EVENT_DEVICE_CONNECTED:
                Log.e(TAG, "Device Connected Event Received");
                ArrayList<String> deviceCaps = espDevice.getDeviceCapabilities();

                if (deviceCaps != null && !deviceCaps.contains("no_pop") && securityType == 1) {
                    System.out.println("fatititititi in eventttttttt YESSSSSSSSS bleutoooth ");
                    espDevice.setProofOfPossession(securityKey);
                    Esp32BleProvisioningPlugin.emitter.success("deviceConnected");
                    tryingToOpenSessionWithWifiSSidAndPassword(ssid, password);
                } else if (deviceCaps.contains("wifi_scan")) {
                    System.out.println("fatititititi in eventttttttt No 0 ");

                } else {
                    System.out.println("fatititititi in eventttttttt No 1");
                }
                break;

            case ESPConstants.EVENT_DEVICE_DISCONNECTED:
                System.out.println("fatititititi in eventttttttt Device disconnected");
                Esp32BleProvisioningPlugin.emitter.success("deviceDisConnected");
                Toast.makeText(activity, "Device disconnected", Toast.LENGTH_LONG).show();
                break;

            case ESPConstants.EVENT_DEVICE_CONNECTION_FAILED:
                System.out.println("fatititititi in eventttttttt Failed to connect with device");
                Esp32BleProvisioningPlugin.emitter.success("failedToConnectToDevice");
                Toast.makeText(activity, "Failed to connect device", Toast.LENGTH_LONG).show();
                break;
        }
    }

    public void tryingToOpenSessionWithWifiSSidAndPassword(String ssid, String password) {
        System.out.println("NOWW Trying to open session  !!!!!!!!!!!!!! ");
        espDevice.provision(ssid, password, new ProvisionListener() {

            @Override
            public void createSessionFailed(Exception e) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Esp32BleProvisioningPlugin.emitter.success("createSessionFailed");
                        System.out.println("create session failed");
                    }
                });
            }

            @Override
            public void wifiConfigSent() {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(" wifi Config Sent");;
                        Esp32BleProvisioningPlugin.emitter.success("wifiConfigSent");
                    }
                });
            }

            @Override
            public void wifiConfigFailed(Exception e) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Esp32BleProvisioningPlugin.emitter.success("wifiConfigFailed");
                        System.out.println(" wifi Config failed");
                    }
                });
            }

            @Override
            public void wifiConfigApplied() {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Esp32BleProvisioningPlugin.emitter.success("wifiConfigApplied");
                        System.out.println(" wifi Config applied");
                    }
                });


            }

            @Override
            public void wifiConfigApplyFailed(Exception e) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Esp32BleProvisioningPlugin.emitter.success("wifiConfigAppliedFailed");
                        System.out.println(" wifi Config applied failed");
                    }
                });


            }

            @Override
            public void provisioningFailedFromDevice(final ESPConstants.ProvisionFailureReason failureReason) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(" provisionin failed from device");
                        switch (failureReason) {
                            case AUTH_FAILED:
                                Esp32BleProvisioningPlugin.emitter.success("provisioninFailedFromDevice_AUTH_FAILED");
                                System.out.println(" provisionin failed from device AUTH_FAILED");
                                break;
                            case NETWORK_NOT_FOUND:
                                Esp32BleProvisioningPlugin.emitter.success("provisioninFailedFromDevice_NETWORK_NOT_FOUND");
                                System.out.println(" provisionin failed from device NETWORK_NOT_FOUND");
                                break;
                            case DEVICE_DISCONNECTED:
                            case UNKNOWN:
                                Esp32BleProvisioningPlugin.emitter.success("provisioninFailedFromDevice_UNKNOWN");
                                System.out.println(" provisionin failed from device UNKNOWN");
                                break;
                        }
                    }
                });
            }

            @Override
            public void deviceProvisioningSuccess() {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Esp32BleProvisioningPlugin.emitter.success("provisioninSuccess");
                        System.out.println("provisionin success");
                    }
                });

            }

            @Override
            public void onProvisioningFailed(Exception e) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Esp32BleProvisioningPlugin.emitter.success("onProvisioninFailed");
                        System.out.println("on provisionin failed");
                    }
                });

            }
        });
    }


    private boolean hasPermissions() {

        if (bleAdapter == null || !bleAdapter.isEnabled()) {

            requestBluetoothEnable();
            return false;

        } else if (!hasLocationPermissions()) {

            requestLocationPermission();
            return false;
        }
        return true;
    }

    private void requestBluetoothEnable() {

        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        activity.startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        Log.d(TAG, "Requested user enables Bluetooth.");
    }

    private boolean hasLocationPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return activity.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        }
        return true;
    }

    private void requestLocationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_FINE_LOCATION);
        }
    }
}
