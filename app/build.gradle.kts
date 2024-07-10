plugins {
    alias(libs.plugins.compose.compiler)
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
    id("androidx.navigation.safeargs.kotlin")
}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}

android {
    namespace = "study.me.please"
    compileSdk = 34

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.6"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }

    packaging {
        resources.merges.add("core.properties")
        resources {
            excludes.addAll(
                listOf(
                    "META-INF/AL2.0",
                    "META-INF/LGPL2.1",
                    "META-INF/LICENSE",
                    "META-INF/LICENSE.txt",
                    "META-INF/license.txt",
                    "META-INF/NOTICE",
                    "META-INF/NOTICE.txt",
                    "META-INF/notice.txt",
                    "META-INF/ASL2.0",
                    "META-INF/*.kotlin_module",
                    "META-INF/gradle/incremental.annotation.processors"
                )
            )
        }
    }

    defaultConfig {
        applicationId = "study.me.please"
        minSdk = 26
        targetSdk = 34
        versionCode = 5
        versionName = "0.2.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        javaCompileOptions {
            annotationProcessorOptions {
                arguments += "room.schemaLocation" to "$projectDir/schemas"
            }
        }
    }

    buildTypes {
        debug {
            isShrinkResources = false
            isMinifyEnabled = false
            applicationIdSuffix = ".test"
        }
        release {
        /*Enables code shrinking, obfuscation, and optimization for only
            your project"s release build type.*/
            isMinifyEnabled = true

            /*Enables resource shrinking, which is performed by the
            Android Gradle plugin.*/
            isShrinkResources = true

            /*Includes the default ProGuard rules files that are packaged with
            the Android Gradle plugin. To learn more, go to the section about
            R8 configuration files.*/
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
        languageVersion = "2.0"
        freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
    }
}

dependencies {
    implementation(project(":Squadris"))



    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.multidex)

    // Kotlin
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlin.reflect)

    // security crypto - EncryptedSharedPreferences
    implementation(libs.androidx.security.crypto)

    //Dagger, Hilt, Navigation
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation)
    ksp(libs.kotlinx.metadata.jvm)
    implementation(libs.androidx.navigation.compose)

    //Retrofit, Okhttp
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //Jetpack compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.material3.material3)
    implementation(libs.androidx.compose.material.material)
    // Android Studio Preview support
    implementation(libs.ui)
    implementation(libs.ui.tooling.preview)
    debugImplementation(libs.ui.tooling)

    implementation(libs.androidx.foundation)
    implementation(libs.androidx.constraintlayout.compose)
    implementation(libs.material3.window.size)
    // Optional - Add full set of material icons
    implementation(libs.material.icons)
    // Optional - Integration with activities
    implementation(libs.androidx.activity.compose)
    // Optional - Integration with ViewModels
    implementation(libs.viewmodel.compose)
    // Optional - Integration with LiveData
    implementation(libs.androidx.runtime.livedata)

    //graphics
    implementation(libs.lottie)
    implementation(libs.coil.compose)
    implementation(libs.coil.gif)
    implementation(libs.coil.svg)

    //Firebase
    implementation(platform(libs.firebase.bom))
    //implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.firestore.ktx)
    //implementation("com.google.firebase:firebase-storage")
    implementation(libs.firebase.play.services)
    implementation(libs.firebase.auth)

    // optional - needed for credentials support from play services, for devices running
    // Android 13 and below.
    implementation(libs.androidx.credentials.auth)

    implementation(libs.androidx.credentials)
    implementation(libs.google.identity)


    // Room components
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.paging)
}