# Startask
[![](https://jitpack.io/v/illiashenkoo/startask.svg)](https://jitpack.io/#illiashenkoo/startask)

Startask is a library designed to accelerate and simplify the development process of Android applications.

## Integration ![Gradle](images/logo_gradle_kotlin.png)
Step 1. Add the JitPack repository to your root build.gradle at the end of repositories.
```groovy
allprojects {
    repositories {
        //...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency
```groovy
dependencies {
    implementation 'com.github.illiashenkoo.startask:startask-utils:X.X.X'
    implementation 'com.github.illiashenkoo.startask:startask-ktx-core:X.X.X'
}
```