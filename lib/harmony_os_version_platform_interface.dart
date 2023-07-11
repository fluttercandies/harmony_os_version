import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'harmony_os_version_method_channel.dart';

abstract class HarmonyOsVersionPlatform extends PlatformInterface {
  /// Constructs a HarmonyOsVersionPlatform.
  HarmonyOsVersionPlatform() : super(token: _token);

  static final Object _token = Object();

  static HarmonyOsVersionPlatform _instance = MethodChannelHarmonyOsVersion();

  /// The default instance of [HarmonyOsVersionPlatform] to use.
  ///
  /// Defaults to [MethodChannelHarmonyOsVersion].
  static HarmonyOsVersionPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [HarmonyOsVersionPlatform] when
  /// they register themselves.
  static set instance(HarmonyOsVersionPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> osVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
