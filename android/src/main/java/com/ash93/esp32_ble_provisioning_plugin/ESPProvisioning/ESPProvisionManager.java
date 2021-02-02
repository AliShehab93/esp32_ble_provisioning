package com.ash93.esp32_ble_provisioning_plugin.ESPProvisioning;// Copyright 2020 Espressif Systems (Shanghai) PTE LTD
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

//package com.ash93.esp32_ble_provisioning_plugin.ESPProvisioning;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;

import com.ash93.esp32_ble_provisioning_plugin.ESPProvisioning.device_scanner.BleScanner;
import com.ash93.esp32_ble_provisioning_plugin.ESPProvisioning.device_scanner.WiFiScanner;
import com.ash93.esp32_ble_provisioning_plugin.ESPProvisioning.listeners.BleScanListener;
import com.ash93.esp32_ble_provisioning_plugin.ESPProvisioning.listeners.QRCodeScanListener;
import com.ash93.esp32_ble_provisioning_plugin.ESPProvisioning.listeners.WiFiScanListener;
import com.ash93.esp32_ble_provisioning_plugin.ESPProvisioning.ESPDevice;
import com.ash93.esp32_ble_provisioning_plugin.ESPProvisioning.ESPConstants;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * App can use this class to provision device. It has APIs to scan devices, scan QR code and connect with the device to get
 * object of ESPDevice.
 */
public class ESPProvisionManager {

    private static final String TAG = "ESP:" + ESPProvisionManager.class.getSimpleName();

    private static ESPProvisionManager provision;

    private ESPDevice espDevice;
    private BleScanner bleScanner;
    private WiFiScanner wifiScanner;
    private Context context;
    private Handler handler;
    private boolean isScanned = false;

    /**
     * This method is used to get singleton instance of
     *
     * @param context Context
     * @return Returns
     */
    public static ESPProvisionManager getInstance(Context context) {

        if (provision == null) {
            provision = new ESPProvisionManager(context);
        }
        return provision;
    }

    private ESPProvisionManager(Context context) {
        this.context = context;
        handler = new Handler();
    }

    /**
     * This method is used to get ESPDevice object with given transport and security.
     *
     * @param transportType Transport type.
     * @param securityType  Security type.
     * @return Returns ESPDevice.
     */
    public ESPDevice createESPDevice(ESPConstants.TransportType transportType, ESPConstants.SecurityType securityType) {

        espDevice = new ESPDevice(context, transportType, securityType);
        return espDevice;
    }

    /**
     * This method is used to get ESPDevice object with given transport and security.
     *
     * @return Returns ESPDevice.
     */
    public ESPDevice getEspDevice() {
        return espDevice;
    }

    /**
     * This method is used to scan BLE devices.
     *
     * @param bleScannerListener BleScanListener for scanning callbacks.
     */
    @RequiresPermission(allOf = {Manifest.permission.BLUETOOTH_ADMIN, Manifest.permission.BLUETOOTH, Manifest.permission.ACCESS_FINE_LOCATION})
    public void searchBleEspDevices(BleScanListener bleScannerListener) {

        Log.e(TAG, "Search for BLE devices");
        bleScanner = new BleScanner(context, bleScannerListener);
        bleScanner.startScan();
    }

    /**
     * This method is used to scan BLE devices with having given prefix in device name.
     *
     * @param prefix             Prefix to filter devices from device name.
     * @param bleScannerListener BleScanListener for scanning callbacks.
     */
    @RequiresPermission(allOf = {Manifest.permission.BLUETOOTH_ADMIN, Manifest.permission.BLUETOOTH, Manifest.permission.ACCESS_FINE_LOCATION})
    public void searchBleEspDevices(String prefix, BleScanListener bleScannerListener) {

        Log.e(TAG, "Search for BLE devices");
        bleScanner = new BleScanner(context, prefix, bleScannerListener);
        bleScanner.startScan();
    }

    /**
     * This method is used to stop BLE scanning.
     */
    @RequiresPermission(allOf = {Manifest.permission.BLUETOOTH_ADMIN, Manifest.permission.BLUETOOTH, Manifest.permission.ACCESS_FINE_LOCATION})
    public void stopBleScan() {

        if (bleScanner != null) {
            bleScanner.stopScan();
        }
    }

    /**
     * This method is used to scan Wi-Fi devices.
     *
     * @param wiFiDeviceScanListener WiFiScanListener for scanning callbacks.
     */
    @RequiresPermission(allOf = {Manifest.permission.CHANGE_WIFI_STATE, Manifest.permission.ACCESS_WIFI_STATE})
    public void searchWiFiEspDevices(WiFiScanListener wiFiDeviceScanListener) {

        wifiScanner = new WiFiScanner(context, wiFiDeviceScanListener);
        wifiScanner.startScan();
    }

    /**
     * This method is used to scan Wi-Fi devices with having given prefix in device name.
     *
     * @param prefix                 Prefix to filter devices from device name.
     * @param wiFiDeviceScanListener WiFiScanListener for scanning callbacks.
     */
    @RequiresPermission(allOf = {Manifest.permission.CHANGE_WIFI_STATE, Manifest.permission.ACCESS_WIFI_STATE})
    public void searchWiFiEspDevices(String prefix, WiFiScanListener wiFiDeviceScanListener) {

        wifiScanner = new WiFiScanner(context, prefix, wiFiDeviceScanListener);
        wifiScanner.startScan();
    }

    private int searchCnt = 0;
    private boolean isDeviceFound = false;

    /**
     * This method will check given ESPDevice is available in scanning or not.
     * It will give callback to app with ESPDevice object if device is available in scanning.
     *
     * @param device             ESPDevice.
     * @param password           Password for Wi-Fi device.
     * @param qrCodeScanListener QRCodeScanListener to give callbacks to app.
     */
    private void isDeviceAvailable(final ESPDevice device, String password, QRCodeScanListener qrCodeScanListener) {

        searchCnt = 0;
        isDeviceFound = false;
        // Check device is available in scanning.
        SearchDeviceTask searchDeviceTask = new SearchDeviceTask(device, password, qrCodeScanListener);
        handler.post(searchDeviceTask);
    }

    class SearchDeviceTask implements Runnable {

        private ESPDevice device;
        private QRCodeScanListener listener;
        private String password;

        SearchDeviceTask(ESPDevice device1, String password1, QRCodeScanListener listener1) {
            searchCnt++;
            device = device1;
            listener = listener1;
            password = password1;
            isDeviceFound = false;
        }

        @Override
        @RequiresPermission(allOf = {Manifest.permission.BLUETOOTH_ADMIN, Manifest.permission.BLUETOOTH,
                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CHANGE_WIFI_STATE,
                Manifest.permission.ACCESS_WIFI_STATE})
        public void run() {

            if (device.getTransportType().equals(ESPConstants.TransportType.TRANSPORT_BLE)) {

                searchBleEspDevices(new BleScanListener() {

                    @Override
                    public void scanStartFailed() {
                        listener.onFailure(new RuntimeException("Please turn on bluetooth and try again."));
                    }

                    @Override
                    @RequiresPermission(Manifest.permission.BLUETOOTH)
                    public void onPeripheralFound(BluetoothDevice btDevice, ScanResult scanResult) {

                        if (!isDeviceFound && btDevice != null && !TextUtils.isEmpty(btDevice.getName())) {

                            if (btDevice.getName().equals(device.getDeviceName())) {
                                // Device found
                                isDeviceFound = true;
                                String serviceUuid = "";

                                if (scanResult.getScanRecord().getServiceUuids() != null && scanResult.getScanRecord().getServiceUuids().size() > 0) {
                                    serviceUuid = scanResult.getScanRecord().getServiceUuids().get(0).toString();
                                }

                                device.setBluetoothDevice(btDevice);
                                device.setPrimaryServiceUuid(serviceUuid);
                            }
                        }
                    }

                    @Override
                    public void scanCompleted() {

                        Log.d(TAG, "scanCompleted");
                        Log.d(TAG, "isDeviceFound : " + isDeviceFound);
                        Log.d(TAG, "searchCnt : " + searchCnt);

                        if (!isDeviceFound) {

                            if (searchCnt != 3) {

                                SearchDeviceTask searchDeviceTask = new SearchDeviceTask(device, password, listener);
                                handler.postDelayed(searchDeviceTask, 500);
                            } else {
                                String errMsg = "" + device.getDeviceName() + " device not found";
                                listener.onFailure(new RuntimeException(errMsg));
                            }
                        } else {
                            listener.deviceDetected(device);
                        }
                    }

                    @Override
                    public void onFailure(Exception e) {

                        e.printStackTrace();
                        Log.d(TAG, "onFailure");
                        Log.d(TAG, "isDeviceFound : " + isDeviceFound);
                        Log.d(TAG, "searchCnt : " + searchCnt);

                        if (!isDeviceFound) {

                            if (searchCnt != 3) {

                                SearchDeviceTask searchDeviceTask = new SearchDeviceTask(device, password, listener);
                                handler.postDelayed(searchDeviceTask, 500);
                            } else {
                                String errMsg = "" + device.getDeviceName() + " device not found";
                                listener.onFailure(new RuntimeException(errMsg));
                            }
                        }
                    }
                });
            }
        }
    }
}
