plugins {
    //alias(libs.plugins.android.application)
    id("com.android.library")
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.squadris.squadris"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        testOptions.targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    //Dagger, Hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.compiler)
    implementation(libs.kotlinx.metadata.jvm)

    implementation(libs.androidx.navigation.compose)
    implementation(libs.coil.compose)

    //Jetpack compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.material)
    implementation(libs.androidx.ui.tooling.preview.android)
    implementation(libs.material3)
    implementation(libs.material.icons)
    implementation(libs.lottie)
    implementation(libs.androidx.constraintlayout.compose)
    implementation(libs.material3.window.size)
    implementation(libs.androidx.multidex)
}