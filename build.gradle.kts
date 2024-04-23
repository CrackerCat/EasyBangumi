// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
}

tasks.create<Delete>("clean") {
    delete {
        rootProject.layout.buildDirectory
    }
}

//subprojects {
//    // 定义检查依赖变化的时间间隔,!!配置为0实时刷新
//    configurations.all {
//        // check for updates every build
//        resolutionStrategy.cacheChangingModulesFor(0, java.util.concurrent.TimeUnit.SECONDS)
//    }
//}