package com.kenkoro.buildLogic

import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.Project

internal fun Project.configureSpotless(extension: SpotlessExtension) {
    extension.apply {
        kotlin {
            ktlint()
            target("**/*.kt")
            targetExclude("**/build/**/*.kt")

            val licenseHeaderFile = rootProject.file("spotless/copyright.kt")
            if (licenseHeaderFile.exists()) {
                val licenseHeader = licenseHeaderFile.readText() + "\n"
                licenseHeader(licenseHeader)
            }
        }
    }
}