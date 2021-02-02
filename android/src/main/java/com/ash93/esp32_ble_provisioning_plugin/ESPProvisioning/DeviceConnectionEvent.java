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

package com.ash93.esp32_ble_provisioning_plugin.ESPProvisioning;

import android.os.Bundle;

/**
 * Event class to send device connection / disconnection events to app.
 */
public class DeviceConnectionEvent {

    private short eventType;
    private Bundle data;

    public DeviceConnectionEvent(short type) {
        eventType = type;
    }

    public short getEventType() {
        return eventType;
    }

    public Bundle getData() {
        return data;
    }

    public void setData(Bundle data) {
        this.data = data;
    }
}
