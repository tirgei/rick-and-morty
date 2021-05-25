// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(BuildPlugins.ktlintPlugin) version Versions.ktlint
    id(BuildPlugins.detektPlugin) version Versions.detekt
    id(BuildPlugins.spotlessPlugin) version Versions.spotless
    id(BuildPlugins.androidLibrary) apply false
    id(BuildPlugins.androidApplication) apply false
    id(BuildPlugins.kotlinAndroid) apply false
    id(BuildPlugins.dokkaPlugin) version Versions.dokka
    id(BuildPlugins.gradleVersionsPlugin) version Versions.gradleVersionsPlugin
}

allprojects {

    repositories {
        google()
        jcenter()
        mavenCentral()
        maven(url = "https://jitpack.io")
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
    }

    apply(plugin = BuildPlugins.dokkaPlugin)

    apply(plugin = BuildPlugins.ktlintPlugin)
    ktlint {
        android.set(true)
        verbose.set(true)
        filter {
            exclude { element -> element.file.path.contains("generated/") }
        }
    }

    configurations.all {
        resolutionStrategy {
            force("org.xerial:sqlite-jdbc:3.34.0")
        }
    }
}

buildscript {
    val jacocoVersion by extra("0.2")

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("com.hiya:jacoco-android:$jacocoVersion")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}")
    }
}

subprojects {

    apply(plugin = BuildPlugins.detektPlugin)
    detekt {
        config = files("${project.rootDir}/detekt.yml")
        parallel = true
    }

    apply(plugin = BuildPlugins.spotlessPlugin)
    spotless {
        kotlin {
            target("**/*.kt")
            licenseHeaderFile(
                rootProject.file("${project.rootDir}/spotless/copyright.kt"),
                "^(package|object|import|interface)"
            )
        }
    }
}