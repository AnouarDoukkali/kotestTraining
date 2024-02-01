/**
 * File: EmptyConventionPlugin.kt
 * Author: Anouar Doukkali
 * Created on:  1/22/2024 2:31 AM
 * Description : Dummy plugin to be used as a template for new plugins.
 * Since: v1.0.0
 */
package plugins.template

import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("ClassIndependentOfModule", "ClassUnconnectedToPackage")
internal class EmptyConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("Hello from EmptyConventionPlugin")
    }
}
