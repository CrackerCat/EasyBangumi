import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.sqldelight)
}
//
//sqldelight {
//    databases {
//        create("BangumiDatabase") {
//            packageName = "com.heyanle.easy_bangumi_multi.sq"
//        }
//    }
//}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
    
    jvm("desktop")
    
    sourceSets {
        val desktopMain by getting
        
        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.sqldelight.android.driver)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(compose.material3)

            implementation(libs.moshi)
            implementation(libs.moshi.kotlin)
            implementation(libs.jsoup)

            implementation(libs.kotlin.coroutines.core)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.serialization)

            implementation(libs.sqldelight.runtime)

            implementation(kotlin("reflect"))

            implementation(project(":data"))
            implementation(project(":base"))
            implementation(project(":extension:source_api"))
            implementation(project(":extension:source_utils"))
            implementation(project(":inject"))
        }
        desktopMain.dependencies {
            implementation(libs.sqldelight.sqlite.driver)
            implementation(compose.desktop.currentOs)
        }
    }
}

android {
    namespace = "com.heyanle.easybangumi.multi"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "com.heyanle.easybangumi.multi"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

compose.desktop {
    application {
        mainClass = "com.heyanle.easybangumi.multi.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.heyanle.easybangumi.multi"
            packageVersion = "1.0.0"
        }
    }
}
