/**
 * File: KotlinJvmConvention.kt
 * Author: Anouar Doukkali
 * Created on:  1/22/2024 2:32 AM
 * Description: Kotlin JVM plugin convention.
 * Since: v1.0.0
 */
package plugins.jvm

import configuration.configureKotlinJvm
import configuration.versionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("ClassIndependentOfModule", "ClassUnconnectedToPackage")
internal class KotlinJvmConvention : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(versionCatalog().findPlugin("kotlin").get().get().pluginId)
            }
            configureKotlinJvm()
        }
    }
}
