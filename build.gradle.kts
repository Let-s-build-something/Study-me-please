// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.gms.google.services) apply false
    alias(libs.plugins.compose.compiler) apply false
    id("com.google.devtools.ksp") version "2.0.0-1.0.22" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://maven.google.com") }
        maven { setUrl("https://jitpack.io") }
    }

    dependencies {
        classpath(libs.androidx.navigation.safe.args.gradle.plugin)
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.hilt.android.gradle.plugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://maven.google.com") }
        maven { setUrl("https://jitpack.io") }
    }
}