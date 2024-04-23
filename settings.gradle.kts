rootProject.name = "EasyBangumi"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
        maven { url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
        maven { url = uri("https://jitpack.io") }
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven { url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
        maven { url = uri("https://jitpack.io") }
    }
}

include(":composeApp")
include(":injekt")
include(":lib_upnp")
