# flutter_native_call_example

Demonstrates how to use the flutter_native_call plugin.

## Getting Started

```dart
import 'package:flutter/material.dart';
import 'package:flutter_native_call/flutter_native_call.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Column(
          children: <Widget>[
            Center(
              child: Text('call'),
            ),
            RaisedButton(
              child: Text("call"),
              onPressed: (){
                FlutterNativeCall.makeCall("9999999999");
              },
            )
          ],
        ),
      ),
    );
  }
}

```