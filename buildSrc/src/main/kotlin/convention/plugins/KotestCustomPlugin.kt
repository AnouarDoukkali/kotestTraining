package convention.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType

// implementing a custom plugin using a dedicated class

internal class KotestCustomPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.apply("java")
        // set default version if property is not set in gradle.properties
        val kotestVersion = project.property("kotest.version") as? String ?: "5.8.0"
        project.dependencies {
            "testImplementation"("io.kotest:kotest-runner-junit5:$kotestVersion")
            "testImplementation"("io.kotest:kotest-assertions-core:$kotestVersion")
            "testImplementation"("io.kotest:kotest-property:$kotestVersion")
        }

        project.tasks.withType<Test>().configureEach {
            useJUnitPlatform()
        }
    }
}
