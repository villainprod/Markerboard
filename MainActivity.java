plugins {
    id 'com.android.application'
}

android {
    namespace 'com.markerboard'
    compileSdk 34

    defaultConfig {
        applicationId "com.markerboard"
        minSdk 23
        targetSdk 34
        versionCode 1
        versionName "1.0"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding true
    }
}

dependencies {
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.11.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    // OkHttp for Google Sheets API calls
    implementation 'com.squareup.okhttp3:okhttp:4.12.0'
    // Gson for JSON parsing
    implementation 'com.google.code.gson:gson:2.10.1'
    // Handler / coroutine-style scheduling
    implementation 'androidx.lifecycle:lifecycle-runtime:2.7.0'
}
