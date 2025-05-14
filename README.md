# IVI Audio Source Manager

An Android-based In-Vehicle Infotainment (IVI) application that demonstrates seamless audio source management across native media, browser-based media (e.g., YouTube), and simulated USB media. The project emphasizes proper handling of Android's AudioFocus to ensure a smooth user experience when switching between different audio sources.

## 🚀 Features

- **Native Media Playback**: Play audio files bundled within the app's assets.
- **Browser Media Playback**: Stream media content via an embedded WebView (e.g., YouTube).
- **USB Media Simulation**: Simulate USB media playback using local audio files.
- **Centralized Audio Focus Management**: Utilize a shared AudioFocusManager to handle audio focus changes consistently across different media sources.
- **Graceful Audio Transitions**: Automatically pause, resume, or stop playback based on audio focus changes.

## 🧱 Architecture

### Activities:
- **MainActivity**: Launchpad to navigate between different media playback activities.
- **NativeMediaActivity**: Handles playback of native audio files.
- **BrowserMediaActivity**: Streams media content via WebView.
- **UsbMediaActivity**: Simulates USB media playback.

### Utilities:
- **AudioFocusManager**: Centralized manager for handling audio focus requests and changes.

## 📁 Project Structure

```
IVI-Audio-Source-Manager
├── app
│   └── src
│       └── main
│           ├── AndroidManifest.xml
│           ├── build.gradle
│           ├── java
│           │   └── com
│           │       └── example
│           │           └── audiosourcemanager
│           │               ├── AudioFocusManager.kt
│           │               ├── BrowserMediaActivity.kt
│           │               ├── MainActivity.kt
│           │               ├── NativeMediaActivity.kt
│           │               └── UsbMediaActivity.kt
│           └── res
│               ├── layout
│               │   └── activity_main.xml
│               └── values
├── build.gradle
├── docs
│   ├── architecture.md
│   ├── flowchart.svg
│   └── focus_handling.md
├── gradle.properties
├── hal_stub
├── README.md
├── screenshots
├── settings.gradle
└── tests
    └── AudioFocusTests.kt

```

## 🛠️ Prerequisites

- **Android Studio**: Latest stable version recommended.
- **Android SDK**: API Level 33 or higher.
- **Java Development Kit (JDK)**: Version 8 or higher.

## ⚙️ Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/sberaconnects/IVI-Audio-Source-Manager.git
   ```

2. **Open in Android Studio**:
   Launch Android Studio.
   Click on "Open an existing project".
   Navigate to the cloned repository folder and select it.

3. **Configure SDK Path**:
    Ensure that the local.properties file contains the correct path to your Android SDK:
  ```bash
    sdk.dir=/path/to/your/Android/Sdk
  ```

4. **Build the Project**:

    Click on "Build" > "Make Project" or press Ctrl+F9 to build the project.

5. **Run the Application**:

    Connect an Android device or start an emulator.
    Click on "Run" > "Run 'app'" or press Shift+F10.

## 🤝 Contributing
Contributions are welcome!


## 📬 Contact
Your Name – sbera.connects@gmail.com
Project Link: https://github.com/sberaconnects/IVI-Audio-Source-Manager