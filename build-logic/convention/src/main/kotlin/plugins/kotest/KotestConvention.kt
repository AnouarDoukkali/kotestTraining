/**
 * File: TestConvention.kt
 * Author: Anouar Doukkali
 * Created on:  1/22/2024 2:32 AM
 * Description: test convention plugin.
 * Since: v1.0.0
 */
package plugins.kotest

import configuration.versionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType

@Suppress("ClassIndependentOfModule", "ClassUnconnectedToPackage")
internal class KotestConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                "testImplementation"(versionCatalog().findBundle("kotest").get())
            }
            tasks.withType<Test>().configureEach {
                useJUnitPlatform()
            }
        }
    }
}
