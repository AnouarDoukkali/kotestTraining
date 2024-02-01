/**
 * File: DokkaConvention.kt
 * Author: Anouar Doukkali
 * Created on:  1/22/2024 2:30 AM
 * Description: Dokka plugin convention.
 * Since: v1.0.0
 */
package plugins.dokka

import configuration.configureDokka
import configuration.versionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("ClassIndependentOfModule", "ClassUnconnectedToPackage")
internal class DokkaConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(versionCatalog().findPlugin("dokka").get().get().pluginId)
            }
            configureDokka()
        }
    }
}
