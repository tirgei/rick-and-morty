plugins {
    id(BuildPlugins.kotlin)
    id(BuildPlugins.javaLibrary)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(Libraries.kotlinStandardLibrary)

    implementation(Libraries.gson)
}