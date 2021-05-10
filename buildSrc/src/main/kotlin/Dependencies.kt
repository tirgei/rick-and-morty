object Versions {

    //Version codes for all the libraries
    const val kotlin = "1.4.21"
    const val buildToolsVersion = "4.1.1"
    const val appCompat = "1.3.0-beta01"
    const val constraintLayout = "2.1.0-alpha2"
    const val ktx = "1.5.0-beta01"
    const val material = "1.3.0-rc01"
    const val hilt = "2.35"
    const val coroutinesVersion = "1.3.9"
    const val lifecycleVersion = "2.3.1"
    const val fragmentKtx = "1.3.3"
    const val navigationVersion = "2.3.5"
    const val room = "2.3.0"

    // Version codes for 3rd part libraries
    const val gson = "2.8.6"
    const val retrofit = "2.9.0"
    const val okhttpLoggingInterceptor = "4.9.0"
    const val timberVersion = "4.1.2"
    const val lottieVersion = "3.7.0"
    const val roundedImageView = "2.3.0"
    const val glide = "4.12.0"
    const val cirlceImageView = "3.1.0"

    //Version codes for all the test libraries
    const val junit4 = "4.13.1"
    const val testRunner = "1.3.1-alpha03"
    const val espresso = "3.4.0-alpha03"
    const val annotation = "1.2.0-beta01"
    const val androidXTest = "1.2.0"
    const val androidXCoreTest = "2.1.0"
    const val hamcrest = "1.3"
    const val robolectric = "4.3.1"
    const val coroutinesTest = "1.2.1"
    const val googleTruth = "1.0.1"
    const val mockk = "1.10.6"
    const val androidxJunit = "1.1.1"
    const val mockito = "2.21.0"
    const val dexmakerMockito = "2.12.1"

    // Gradle Plugins
    const val ktlint = "9.4.1"
    const val detekt = "1.14.2"
    const val spotless = "5.9.0"
    const val dokka = "1.4.20"
    const val gradleVersionsPlugin = "0.36.0"
    const val jacoco = "0.8.4"
    const val secretsGradleVersion = "0.5"
}

object BuildPlugins {
    //All the build plugins are added here
    const val kotlin = "kotlin"
    const val kotlinKapt = "kotlin-kapt"
    const val daggerHiltPlugin = "dagger.hilt.android.plugin"
    const val androidLibrary = "com.android.library"
    const val ktlintPlugin = "org.jlleitschuh.gradle.ktlint"
    const val detektPlugin = "io.gitlab.arturbosch.detekt"
    const val spotlessPlugin = "com.diffplug.spotless"
    const val dokkaPlugin = "org.jetbrains.dokka"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val kotlinParcelizePlugin = "org.jetbrains.kotlin.plugin.parcelize"
    const val gradleVersionsPlugin = "com.github.ben-manes.versions"
    const val jacocoAndroid = "com.hiya.jacoco-android"
    const val javaLibrary = "java-library"
    const val secretsGradle = "com.google.secrets_gradle_plugin"
    const val navigationPlugin = "androidx.navigation.safeargs.kotlin"
}

object Libraries {
    //Any Library is added here
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val materialComponents = "com.google.android.material:material:${Versions.material}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val coroutinesPlayServices = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutinesVersion}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

     // 3rd party libraries
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLoggingInterceptor}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
    const val lottie = "com.airbnb.android:lottie:${Versions.lottieVersion}"
    const val roundedImageView = "com.makeramen:roundedimageview:${Versions.roundedImageView}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val circleImageView = "de.hdodenhof:circleimageview:${Versions.cirlceImageView}"
}

object LibraryCompilers {
    // Any library compilers is added here
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
}

object TestLibraries {
    //any test library is added here
    const val androidxTest = "androidx.test.core:${Versions.androidXTest}"
    const val androidXCoreTest = "androidx.arch.core:core-testing:${Versions.androidXCoreTest}"
    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val annotation = "androidx.annotation:annotation:${Versions.annotation}"
    const val navigationTesting = "androidx.navigation:navigation-testing:${Versions.navigationVersion}"
    const val roomTesting = "androidx.room:room-testing:${Versions.room}"
    const val hamcrest = "org.hamcrest:hamcrest-all:${Versions.hamcrest}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
    const val googleTruth = "com.google.truth:truth:${Versions.googleTruth}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val mockkAndroid = "io.mockk:mockk-android:${Versions.mockk}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockito}"
    const val dexmakerMockito = "com.linkedin.dexmaker:dexmaker-mockito:${Versions.dexmakerMockito}"
}

object AndroidSdk {
    const val minSdkVersion = 21
    const val compileSdkVersion = 30
    const val targetSdkVersion = compileSdkVersion
    const val buildToolsVersion = "30.0.3"
    const val versionCode = 1
    const val versionName = "1.0"
}