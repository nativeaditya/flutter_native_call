# flutter native call

A new Flutter plugin. for native call feature in android(only).

## Getting Started

To use this plugin, add `flutter_native_call` as a dependency in your pubspec.yaml file. For example:

```dart
dependencies:
  flutter_native_call: ^0.0.2
```

run command
```
$ flutter pub get
```

You need to add a permission to AndroidManifest.xml:

```xml
<uses-permission android:name="android.permission.CALL_PHONE" />
```
import it


```dart
import 'package:flutter_native_call/flutter_native_call.dart';
```

use it


```dart
FlutterNativeCall.makeCall("9999999999");
```