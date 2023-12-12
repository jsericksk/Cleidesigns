import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                add("implementation", project(":core:common"))

                add("implementation", libs.findLibrary("core.ktx").get())
                add("implementation", libs.findLibrary("androidx.constraintlayout").get())
                add("implementation", libs.findLibrary("core.ktx").get())
                add("implementation", libs.findLibrary("androidx.appcompat").get())
                add("implementation", libs.findLibrary("google.material").get())
                add("implementation", libs.findLibrary("lifecycle.runtime.ktx").get())
                add("implementation", libs.findLibrary("androidx.legacy.support.v4").get())

                // Compose
                add("implementation", platform(libs.findLibrary("compose.bom").get()))
                add("implementation", libs.findLibrary("activity.compose").get())
                add("implementation", libs.findLibrary("compose.ui").get())
                add("implementation", libs.findLibrary("compose.ui.viewbinding").get())
                add("implementation", libs.findLibrary("compose.ui.graphics").get())
                add("implementation", libs.findLibrary("compose.ui.tooling").get())
                add("implementation", libs.findLibrary("compose.ui.tooling.preview").get())
                add("implementation", libs.findLibrary("compose.material").get())

                // Coil
                add("implementation", libs.findLibrary("coil").get())
            }
        }
    }
}