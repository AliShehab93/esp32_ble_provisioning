import 'package:esp32_ble_provisioning/esp32_ble_provisioning.dart';
import 'package:flutter/material.dart';
import 'send_config_parameters_to_device.dart';

class SearchForBleDevices extends StatefulWidget {
  @override
  _SearchForBleDevicesState createState() => _SearchForBleDevicesState();
}

class _SearchForBleDevicesState extends State<SearchForBleDevices> {
  List<String> bluetoothDevices = [];
  bool isLoading = false;
  double width = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Search for devices...'),
      ),
      body: LayoutBuilder(
        builder: (context, constraints) {
          width = constraints.maxWidth;
          return Stack(
            alignment: Alignment.center,
            children: [
              Column(
                children: [
                  Center(
                    child: Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: MaterialButton(
                        onPressed: () async {
                          try {
                            setState(() {
                              isLoading = true;
                              bluetoothDevices = [];
                            });
                            Esp32BleProvisioning.searchForAvailableDevices(
                              (stream) {
                                setState(() {
                                  if (stream is String) {
                                    print("there is no prmissionnn $stream");
                                    isLoading = false;
                                  } else {
                                    print('streamingg 00 :::  $stream');
                                    print(
                                        'streamingg 11 :::  ${stream.runtimeType}');
                                    print(
                                        'streamingg 22 :::  ${stream is List}');
                                    print(
                                        'streamingg 33 :::  ${stream is String}');

                                    bluetoothDevices = [];
                                    stream.forEach((element) {
                                      bluetoothDevices.add(element);
                                    });
                                    isLoading = false;
                                    setState(() {});
                                    print(
                                        'dataaa @@@###@@@##  :: is $stream   $bluetoothDevices');
                                  }
                                });
                              },
                            );
                          } catch (e) {
                            print("error in herrrreee is: $e");
                          }
                        },
                        child: Text(
                          "Search for bluetooth devices",
                          style: TextStyle(color: Colors.white),
                        ),
                        color: Colors.blue,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Row(
                      children: [
                        Column(
                          children: getListOfBluetoothDevices(context),
                        ),
                      ],
                    ),
                  ),
                ],
              ),
              isLoading
                  ? CircularProgressIndicator(
                      backgroundColor: Colors.black26,
                    )
                  : Container()
            ],
          );
        },
      ),
    );
  }

  List<Widget> getListOfBluetoothDevices(BuildContext context) {
    List<Widget> returned = [];
    bluetoothDevices.forEach((element) {
      returned.add(GestureDetector(
        onTap: () async {
          print('elementt iss $element');
          Navigator.of(context).pushReplacement(
            MaterialPageRoute<void>(
                builder: (_) => SendConfigParametersToDevice(
                      deviceName: element,
                    )),
          );
        },
        child: Container(
          width: width / 1.1,
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text('$element'),
          ),
          decoration: BoxDecoration(
            border:
                Border(bottom: BorderSide(color: Colors.blueGrey, width: 0.2)),
          ),
        ),
      ));
    });
    return returned;
  }
}
