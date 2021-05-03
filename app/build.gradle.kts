plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinParcelizePlugin)
    id(BuildPlugins.ktlintPlugin)
    id(BuildPlugins.jacocoAndroid)
    id(BuildPlugins.daggerHiltPlugin)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.navigationPlugin)
    id(BuildPlugins.secretsGradle) version Versions.secretsGradleVersion
}

jacoco {
    toolVersion = Versions.jacoco
}

android {

    compileSdkVersion(AndroidSdk.compileSdkVersion)
    buildToolsVersion(AndroidSdk.buildToolsVersion)

    android.buildFeatures.dataBinding = true
    android.buildFeatures.viewBinding = true

    defaultConfig {
        applicationId = "com.tirgei.rickandmorty"
        minSdkVersion(AndroidSdk.minSdkVersion)
        targetSdkVersion(AndroidSdk.targetSdkVersion)
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName
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

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        dataBinding = true
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(Libraries.kotlinStandardLibrary)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.materialComponents)
    implementation(Libraries.viewModelKtx)
    implementation(Libraries.runtimeKtx)
    implementation(Libraries.fragmentKtx)
    implementation(Libraries.livedataKtx)
    implementation(Libraries.coroutines)
    implementation(Libraries.coroutinesPlayServices)
    implementation(Libraries.navigationFragment)
    implementation(Libraries.navigationUI)

    implementation(Libraries.gson)
    implementation(Libraries.hilt)
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitConverterGson)
    implementation(Libraries.okhttpLoggingInterceptor)
    implementation(Libraries.timber)
    implementation(Libraries.lottie)
    implementation(Libraries.roundedImageView)
    implementation(Libraries.circleImageView)
    implementation(Libraries.glide)

    kapt(LibraryCompilers.hiltCompiler)
    kapt(LibraryCompilers.glideCompiler)

    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
    androidTestImplementation(TestLibraries.annotation)
    androidTestImplementation(TestLibraries.navigationTesting)

    testImplementation(TestLibraries.junit4)
}