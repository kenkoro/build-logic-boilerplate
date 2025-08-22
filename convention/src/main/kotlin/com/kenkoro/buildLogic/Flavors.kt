@file:Suppress("EnumEntryName")

package com.kenkoro.buildLogic

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ProductFlavor

enum class FlavorDimension {
    server
}

enum class Flavor(
    val dimension: FlavorDimension,
    val applicationIdSuffix: String? = null,
    val endpoint: String? = null
) {
    dev(FlavorDimension.server, ".server", "https://dev.localhost/")
}

internal fun configureFlavors(
    extension: ApplicationExtension,
    configuration: ProductFlavor.(Flavor) -> Unit = {}
) {
    extension.apply {
        FlavorDimension.entries.forEach { dimension ->
            flavorDimensions += dimension.name
        }
        productFlavors {
            Flavor.entries.forEach { flavor ->
                register(flavor.name) {
                    dimension = flavor.dimension.name
                    configuration(flavor)
                    flavor.applicationIdSuffix?.let { suffix ->
                        applicationIdSuffix = suffix
                    }
                }
            }
        }
    }
}