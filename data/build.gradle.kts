
plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(AndroidSdk.compileSdkVersion)
    buildToolsVersion(AndroidSdk.buildToolsVersion)

    defaultConfig {
        minSdkVersion(AndroidSdk.minSdkVersion)
        targetSdkVersion(AndroidSdk.targetSdkVersion)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    testOptions {
        animationsDisabled = true
        unitTests.apply {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(Libraries.kotlinStandardLibrary)

    implementation(Libraries.coroutines)
    implementation(Libraries.coroutinesPlayServices)

    // Room
    implementation(Libraries.roomKtx)
    implementation(Libraries.roomRuntime)
    kapt(LibraryCompilers.roomCompiler)

    // GSON & Retrofit
    implementation(Libraries.gson)
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitConverterGson)
    implementation(Libraries.okhttpLoggingInterceptor)

    // Tests
    androidTestImplementation(TestLibraries.roomTesting)

}