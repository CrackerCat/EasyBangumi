plugins {
    id("java-library")
    alias(libs.plugins.jetbrainsKotlinJvm)
}

kotlin {
    jvmToolchain(17)

}

dependencies {
    compileOnly(libs.kotlin.coroutines.core)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}