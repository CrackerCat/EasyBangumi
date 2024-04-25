plugins {
    id("java-library")
    alias(libs.plugins.jetbrainsKotlinJvm)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.sqldelight)
}


kotlin {
    jvmToolchain(11)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
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