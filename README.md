[![release](https://img.shields.io/badge/release-v1.0-blue.svg)](https://github.com/Stevemaster92/LineImageListItems)
[![API](https://img.shields.io/badge/API-9%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=9)

![alt text](https://github.com/Stevemaster92/LineImageListItems/blob/master/screenshots/one_line_items.png "OneLineImageItems")
![alt text](https://github.com/Stevemaster92/LineImageListItems/blob/master/screenshots/three_group_one_child_items.png "ThreeGroupOneChildItems")

# LineImageListItems (LILI)
[LineImageListItems](https://github.com/Stevemaster92/LineImageListItems) is an easy-to-use library which provides default list items, adapters, and list fragments fitting daily Android development with [ListView](https://developer.android.com/reference/android/widget/ListView.html)s.
The library is implemented in a way such that custom changes to the layout of the different list items can be made easily.
Furthermore, one can extend the functionalities of the provided models, adapters, and fragments to their personal usage and create own classes of each component.

## Getting started
At the moment, only an Android Archive (AAR) file of the library exists.
Work on a more convenient, Maven-/Gradle-based solution is still going on.
In order to use the library:

 1. Download the library from [here](https://github.com/Stevemaster92/LineImageListItems/raw/master/lili/lili-release.aar).
 2. Copy the downloaded AAR file to `app/libs/` of your Android project.
 3. Add the following to your project level `build.gradle`
  ```gradle
  repositories {
      flatDir {
          dirs 'libs'
      }
  }
  ```

 4. Add the following to your app `build.gradle`
 ```gradle
 dependencies {
   compile(name: 'lili-release', ext: 'aar')
 }
 ```
 
 5. In Android Studio, select **File > Sync Project with Gradle Files** or click **Sync Now**.

## Documentation
Refer to the [Wiki](https://github.com/Stevemaster92/LineImageListItems/wiki) for more information about the library's components and how to integrate them in your Android app.

## Example App
You can download an example Android application from [here](https://play.google.com/store) or take a look at the example [code](https://github.com/Stevemaster92/LineImageListItems/tree/master/app).

## License
LineImageListItems library for Android

Copyright (c) 2018 Stefan Haselwanter (https://github.com/Stevemaster92).

```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and limitations under the License.
```
