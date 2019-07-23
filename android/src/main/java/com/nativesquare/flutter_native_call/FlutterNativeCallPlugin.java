package com.nativesquare.flutter_native_call;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterNativeCallPlugin */
public class FlutterNativeCallPlugin implements MethodCallHandler {
  /**
   * Plugin registration.
   */

  private PluginRegistry.Registrar registrar;

  public FlutterNativeCallPlugin(Registrar registrar) {
    this.registrar = registrar;
  }

  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_native_call");
    channel.setMethodCallHandler(new FlutterNativeCallPlugin(registrar));
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("makeCall")) {
      String phone = call.argument("phone");
      makeCall(phone);
    } else {
      result.notImplemented();
    }
  }

  void makeCall(String phone) {
    Intent callIntent = new Intent(Intent.ACTION_CALL); //use ACTION_CALL class
    callIntent.setData(Uri.parse("tel:" + phone));
    if (registrar.context().checkSelfPermission( Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
      //request permission from user if the app hasn't got the required permission
      registrar.activity().requestPermissions(
              new String[]{Manifest.permission.CALL_PHONE},   //request specific permission from user
              10);
      return;
    }
      try {
      registrar.context().startActivity(callIntent);//call activity and make phone call
    } catch (android.content.ActivityNotFoundException ex) {
      Toast.makeText(registrar.context(), "Call not connected", Toast.LENGTH_SHORT).show();
    }
  }

}
