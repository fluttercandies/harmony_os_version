import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'harmony_os_version_platform_interface.dart';

/// An implementation of [HarmonyOsVersionPlatform] that uses method channels.
class MethodChannelHarmonyOsVersion extends HarmonyOsVersionPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('harmony_os_version');

  @override
  Future<String?> osVersion() async {
    final version = await methodChannel.invokeMethod<String>('osVersion');
    return version;
  }
}
