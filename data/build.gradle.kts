
plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.daggerHiltPlugin)
}

android {
    compileSdkVersion(AndroidSdk.compileSdkVersion)
    buildToolsVersion(AndroidSdk.buildToolsVersion)

    defaultConfig {
        minSdkVersion(AndroidSdk.minSdkVersion)
        targetSdkVersion(AndroidSdk.targetSdkVersion)
        testInstrumentationRunner = "com.tirgei.data.HiltTestRunner"
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

    packagingOptions {
        pickFirst("META-INF/*")
    }

}

dependencies {
    implementation(project(":domain"))
    implementation(Libraries.kotlinStandardLibrary)

    implementation(Libraries.coroutines)
    implementation(Libraries.coroutinesPlayServices)

    // Hilt
    implementation(Libraries.hilt)
    kapt(LibraryCompilers.hiltCompiler)

    // Room
    implementation(Libraries.roomKtx)
    implementation(Libraries.roomRuntime)
    kapt(LibraryCompilers.roomCompiler)

    // GSON & Retrofit
    implementation(Libraries.gson)
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitConverterGson)
    implementation(Libraries.okhttpLoggingInterceptor)

    // Unit Tests
    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.hamcrest)
    testImplementation(TestLibraries.androidXCoreTest)
    testImplementation(TestLibraries.robolectric)
    testImplementation(TestLibraries.coroutinesTest)
    testImplementation(TestLibraries.googleTruth)
    testImplementation(TestLibraries.mockitoCore)
    testImplementation(TestLibraries.turbine)

    // Instrumented Tests
    androidTestImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.roomTesting)
    androidTestImplementation(TestLibraries.androidXCoreTest)
    androidTestImplementation(TestLibraries.androidxJunit)
    androidTestImplementation(TestLibraries.coroutinesTest)
    androidTestImplementation(TestLibraries.googleTruth)
    androidTestImplementation(TestLibraries.dexmakerMockito)
    androidTestImplementation(TestLibraries.mockitoCore)
    androidTestImplementation(TestLibraries.espresso)
    androidTestImplementation(TestLibraries.turbine)
    androidTestImplementation(TestLibraries.hilt)
    kaptAndroidTest(LibraryCompilers.hiltCompiler)

}