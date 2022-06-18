# godot-android-firebase-message
Godot Android plugin for the in-app reviews
https://developer.android.com/guide/playcore/in-app-review/kotlin-java

## Usage

### method
* requestReview()   

```gdscript
if Engine.has_singleton("RequestReview"):
		var singleton = Engine.get_singleton("RequestReview")
		singleton.requestReview()
```

## Compiling

Steps to build:

1. Clone this Git repository
2. Run `./gradlew build` in the cloned repository
3. copy *.aar and gdap files
```bash
cp ./GodotAndroidRequestReview/build/outputs/aar/GodotAndroidRequestReview-release.aar ${YOUR_PROJECT}/android/plugins/RequestReview-release.aar
cp RequestReview.gdap ${YOUR_PROJECT}/android/plugin
```
