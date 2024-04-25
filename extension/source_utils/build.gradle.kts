plugins {
    id("java-library")
    alias(libs.plugins.jetbrainsKotlinJvm)
}
kotlin {
    jvmToolchain(11)

}

dependencies {
    compileOnly(libs.kotlin.coroutines.core)
    compileOnly(libs.ktor.client.core)
    compileOnly(libs.ktor.client.serialization)
    compileOnly(libs.moshi)
    compileOnly(libs.jsoup)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}