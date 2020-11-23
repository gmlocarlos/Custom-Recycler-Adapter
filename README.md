# CustomRecyclerAdapter
A generic adapter for recyclerview, forget about creating an adapter for each recyclerview in your application.

This library works with androidx and databinding.

# Installation
**Step 1.** Add the JitPack repository to your build file. Add it in your project's build.gradle at the end of repositories:
```gradle
allprojects {
    repositories {
	...
	maven { url 'https://jitpack.io' }
    }
}
```
**Step 2.** Enable databinding in your app's module build.gradle
```gradle
android {
	...
	dataBinding{
		enabled = true
	}
}
```
**Step 3.** Add the dependency in your app's module build.gradle
```gradle
dependencies {
    implementation "com.github.gmlocarlos:Custom-Recycler-Adapter:1.0.0"
}
```