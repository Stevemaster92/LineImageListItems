[![release](https://img.shields.io/badge/release-v1.0-blue.svg)](https://github.com/Stevemaster92/LineImageListItems)
[![API](https://img.shields.io/badge/API-17%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=17)

![alt text](https://github.com/Stevemaster92/LineImageListItems/blob/master/screenshots/one_line_items.png "OneLineImageItems")
![alt text](https://github.com/Stevemaster92/LineImageListItems/blob/master/screenshots/three_group_one_child_items.png "ThreeGroupOneChildItems")

# LineImageListItems (LILI)
[LineImageListItems](https://github.com/Stevemaster92/LineImageListItems) is an easy-to-use library which provides default list items, adapters, and list fragments fitting daily Android development when working with lists.
It employs the following Android components and patterns:
    
    * [RecyclerView](https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView) for flexible list views and layouts.
    * [ViewHolder](https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView.ViewHolder) for easy data-view binding.
    * [SwipeRefreshLayout](https://developer.android.com/reference/androidx/swiperefreshlayout/widget/SwipeRefreshLayout) for gesture-based data refreshing.
    * [ViewModel](https://developer.android.com/reference/androidx/lifecycle/ViewModel) and [LiveData](https://developer.android.com/reference/androidx/lifecycle/LiveData) for lifecycle-aware background data loading.
    
The library includes pre-defined layouts for the different list items which can be adjusted to personal needs.
Furthermore, one can easily extend the basic functions of the provided models, adapters, and fragments by creating sub classes of each component.

## Getting started
At the moment, only an Android Archive (AAR) file of the library exists.
Work on a more convenient, Maven-/Gradle-based solution is still going on.
In order to use it:

 1. Download the library from [here](https://github.com/Stevemaster92/LineImageListItems/raw/master/lili/lili-release.aar).
 2. Copy the downloaded AAR file to `app/libs/` of your Android project.
 3. Add the following to your project `build.gradle`
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
   implementation(name: 'lili-release', ext: 'aar')
 }
 ```
 
 5. In Android Studio, select **File > Sync Project with Gradle Files** or click **Sync Now**.
 6. Import the desired Java classes and resource files.

## Documentation
Refer to the [Wiki](https://github.com/Stevemaster92/LineImageListItems/wiki) for more information about the library's components and how to integrate them in your Android app.

## Example App
You can either download the example [application](https://play.google.com/store) or take a look at the [code](https://github.com/Stevemaster92/LineImageListItems/tree/master/app).

## License
LineImageListItems library for Android

Copyright (c) 2020 Stefan Haselwanter (https://github.com/Stevemaster92).

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
