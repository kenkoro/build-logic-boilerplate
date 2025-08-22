plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.spotless.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = libs.plugins.com.kenkoro.android.application.asProvider().get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidFlavors") {
            id = libs.plugins.com.kenkoro.android.application.flavors.get().pluginId
            implementationClass = "AndroidApplicationFlavorsConventionPlugin"
        }
        register("androidFormatting") {
            id = libs.plugins.com.kenkoro.android.application.formatting.get().pluginId
            implementationClass = "AndroidApplicationFormattingConventionPlugin"
        }
    }
}