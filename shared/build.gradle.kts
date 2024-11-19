import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            api(libs.gitlive.firebase.kotlin.crashlytics)
            implementation("co.touchlab:kermit:2.0.4")
            implementation("co.touchlab:kermit-crashlytics:2.0.4")
            implementation("co.touchlab.crashkios:crashlytics:0.9.0") }
    }


}

android {
    namespace = "org.livewall.firebase.example.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
//dependencies {
//    implementation(kotlin("script-runtime"))
//    implementation(libs.androidx.media3.common.ktx)
//    implementation(libs.firebase.crashlytics.buildtools)
//    implementation(libs.cronet.embedded)
//
//}