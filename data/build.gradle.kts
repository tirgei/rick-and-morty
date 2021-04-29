
plugins {
    id(BuildPlugins.kotlin)
    id(BuildPlugins.javaLibrary)
    id(BuildPlugins.kotlinKapt)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":domain"))
    implementation(Libraries.kotlinStandardLibrary)

    implementation(Libraries.coroutines)
    implementation(Libraries.coroutinesPlayServices)

    implementation(Libraries.gson)
    implementation(Libraries.hilt)
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitConverterGson)
    implementation(Libraries.okhttpLoggingInterceptor)

    kapt(LibraryCompilers.hiltCompiler)
}