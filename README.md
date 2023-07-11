# harmony_os_version

[![pub package](https://img.shields.io/pub/v/harmony_os_version.svg)](https://pub.dartlang.org/packages/harmony_os_version)
[![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://choosealicense.com/licenses/mit/)

We use the `harmony_os_version` plugin to get harmony os version.

## Usage

To use this plugin, add `harmony_os_version` as a dependency in your pubspec.yaml file. For example:
```yaml
dependencies:
  harmony_os_version: ^1.0.0
```

## Example

``` dart
_xxx() async {
    String? osVersion = HarmonyOsVersion().osVersion();
    print(osVersion);
 }
```
