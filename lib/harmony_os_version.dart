
import 'harmony_os_version_platform_interface.dart';

class HarmonyOsVersion {
  Future<String?> getPlatformVersion() {
    return HarmonyOsVersionPlatform.instance.osVersion();
  }
}
