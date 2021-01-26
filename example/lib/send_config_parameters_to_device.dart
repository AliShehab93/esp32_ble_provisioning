import 'package:esp32_ble_provisioning_plugin/esp32_ble_provisioning_plugin.dart';
import 'package:flutter/material.dart';

class SendConfigParametersToDevice extends StatefulWidget {
  final String deviceName;

  const SendConfigParametersToDevice({Key key, this.deviceName})
      : super(key: key);

  @override
  _SecurityKeyAndWifiSsidPasswordState createState() =>
      _SecurityKeyAndWifiSsidPasswordState();
}

class _SecurityKeyAndWifiSsidPasswordState
    extends State<SendConfigParametersToDevice> {
  TextEditingController securityKeyEditingController = TextEditingController();
  TextEditingController wifiSsidEditingController = TextEditingController();
  TextEditingController wifiPasswordEditingController = TextEditingController();

  String statusReceived = '';
  bool submitIsClicked = false;
  bool connectToDeviceVisibility = true;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Connect To Device Page'),
      ),
      body: SingleChildScrollView(
        child: Column(
          children: [
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: TextFormField(
                controller: securityKeyEditingController,
                decoration: InputDecoration(labelText: "Security Key"),
              ),
            ),
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: TextFormField(
                controller: wifiSsidEditingController,
                decoration: InputDecoration(labelText: "Wifi Ssid"),
              ),
            ),
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: TextFormField(
                controller: wifiPasswordEditingController,
                decoration: InputDecoration(labelText: "Wifi Password"),
              ),
            ),
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Visibility(
                visible: true,//connectToDeviceVisibility,
                child: MaterialButton(
                  onPressed: () async {
                    try {
                      statusReceived = '';
                      print('devicess ${widget.deviceName}');
                      print('security ${securityKeyEditingController.text}');
                      print('security ${wifiSsidEditingController.text}');
                      print('security ${wifiPasswordEditingController.text}');

                      Esp32BleProvisioningPlugin.connectToDevice((msg) {
                        setState(() {
                          print('msg is $msg');
                          statusReceived += '$msg ';
                        });
                      },
                          deviceName: '${widget.deviceName}',//widget.deviceName,PW101_A4CF12139FD0
                          securityKey:'${securityKeyEditingController.text}',// securityKeyEditingController.text,abcd1234
                          ssid: '${wifiSsidEditingController.text}',//,ali
                          password: '${wifiPasswordEditingController.text}',//ali70839713
                      );
                      submitIsClicked = true;
                      connectToDeviceVisibility = false;
                      setState(() {});
                    } catch (e) {
                      print("error in herrrreee is: $e");
                    }
                  },
                  child: Text(
                    "Connect To Device",
                    style: TextStyle(color: Colors.white),
                  ),
                  color: Colors.blue,
                ),
              ),
            ),
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: submitIsClicked ? Column(
                children: [
                  statusReceived == '' ? Text('Loading...') : Container(),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: statusReceived.contains('deviceConnected')
                        ? Text('Device Connected', style: TextStyle(
                        color: Colors.green
                    ))
                        : Text('...'),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: statusReceived.contains('wifiConfigSent')
                        ? Text('Config Wifi Sent', style: TextStyle(
                        color: Colors.green
                    ))
                        : Text('...'),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: statusReceived.contains('wifiConfigApplied')
                        ? Text('Config Wifi Applied', style: TextStyle(
                        color: Colors.green
                    ))
                        : Text('...'),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: statusReceived.contains('provisioninSuccess')
                        ? Text('Provision Done', style: TextStyle(
                        color: Colors.green
                    ))
                        : Text('...'),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: (!statusReceived.contains('provisioninSuccess') && statusReceived.contains('deviceDisConnected')) ||
                        statusReceived.contains('failedToConnectToDevice') ||
                        statusReceived.contains('createSessionFailed') ||
                        statusReceived.contains('wifiConfigFailed') ||
                        statusReceived.contains('wifiConfigAppliedFailed') ||
                        statusReceived.contains
                            ('provisioninFailedFromDevice_AUTH_FAILED') ||
                        statusReceived.contains
                            ('provisioninFailedFromDevice_NETWORK_NOT_FOUND') ||
                        statusReceived.contains
                            ('provisioninFailedFromDevice_UNKNOWN') ||
                        statusReceived.contains('onProvisioninFailed')
                        ? Text('Provision Failed', style: TextStyle(
                      color: Colors.red
                    ),)
                        : Container(),
                  ),
                ],
              ) : Container(),
            )
          ],
        ),
      ),
    );
  }
}
