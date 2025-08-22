import com.android.build.api.dsl.ApplicationExtension
import com.kenkoro.buildLogic.configureFlavors
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationFlavorsConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<ApplicationExtension> {
                configureFlavors(this) {
                    buildConfigField("String", "BASE_URL", "\"$it.endpoint\"")
                }
            }
        }
    }
}