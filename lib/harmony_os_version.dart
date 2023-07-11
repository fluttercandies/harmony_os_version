
import 'harmony_os_version_platform_interface.dart';

class HarmonyOsVersion {
  Future<String?> osVersion() {
    return HarmonyOsVersionPlatform.instance.osVersion();
  }
}
