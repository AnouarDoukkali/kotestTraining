/**
 * File: DetektConvention.kt
 * Author: Anouar Doukkali
 * Created on:  1/22/2024 2:30 AM
 * Description: Detekt convention plugin.
 * Since: v1.0.0
 */
package plugins.detekt

import configuration.configureDetekt
import configuration.versionCatalog
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

@Suppress("ClassIndependentOfModule", "ClassUnconnectedToPackage")
internal class DetektConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(versionCatalog().findPlugin("detekt").get().get().pluginId)
            }
            val extension = extensions.getByType<DetektExtension>()
            configureDetekt(extension)
        }
    }
}
