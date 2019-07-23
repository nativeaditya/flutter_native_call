import 'dart:async';

import 'package:flutter/services.dart';

class FlutterNativeCall {
  static const MethodChannel _channel =
      const MethodChannel('flutter_native_call');


  static Future<String> makeCall(String phone) async {
    await _channel.invokeMethod('makeCall',{"phone":phone});
    return "Done";
  }
}
