plugins {
    id("java-library")
    alias(libs.plugins.jetbrainsKotlinJvm)
}
kotlin {
    jvmToolchain(11)

}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}