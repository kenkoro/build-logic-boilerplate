import com.diffplug.gradle.spotless.SpotlessExtension
import com.kenkoro.buildLogic.configureSpotless
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AndroidApplicationFormattingConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "com.diffplug.spotless")

            extensions.configure<SpotlessExtension> {
                configureSpotless(this)
            }
        }
    }
}