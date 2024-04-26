plugins {
    id("java-library")
    alias(libs.plugins.jetbrainsKotlinJvm)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.sqldelight)
}


kotlin {
    jvmToolchain(17)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

sqldelight {
    databases {
        create("Database") {
            packageName.set("com.heyanle.easybangumi.multi")
            dialect(libs.sqldelight.dialects.sql)
            schemaOutputDirectory.set(project.file("./src/main/sqldelight"))
        }
    }
}

dependencies {
    implementation(libs.moshi)
    implementation(project(":base"))

    api(libs.sqldelight.sqlite.driver)
    api(libs.sqldelight.coroutines)
    api(libs.sqldelight.runtime)
}