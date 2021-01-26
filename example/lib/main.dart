import 'package:flutter/material.dart';
import 'search_for_ble_devices.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  List<String> bluetoothDevices = [];
  bool isLoading = false;
  double width = 0;

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Esp 32 ble provisioning'),
        ),
        body: LayoutBuilder(
          builder: (context, constraints) {
            width = constraints.maxWidth;
            return Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Padding(
                  padding: const EdgeInsets.all(50.0),
                  child: Text(
                    "Please reset your esp32 device before going to next page",
                    textAlign: TextAlign.center,
                    style: TextStyle(color: Colors.black),
                  ),
                ),

                Center(
                  child: Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: MaterialButton(
                      onPressed: () async {
                        Navigator.of(context).push(
                          MaterialPageRoute<void>(
                              builder: (_) => SearchForBleDevices(
                              )),
                        );
                      },
                      child: Text(
                        "Start Provisioning",
                        style: TextStyle(color: Colors.white),
                      ),
                      color: Colors.blue,
                    ),
                  ),
                ),
              ],
            );
          },
        ),
      ),
    );
  }
}
