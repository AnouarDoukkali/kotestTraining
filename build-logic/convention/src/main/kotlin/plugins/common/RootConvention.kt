/**
 * File: CommonConvention.kt
 * Author: Anouar Doukkali
 * Created on:  1/22/2024 2:30 AM
 * Description: This file contains the common convention plugin.
 * Since: v1.0.0
 */
package plugins.common

import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Copy
import org.gradle.kotlin.dsl.register

@Suppress("ClassIndependentOfModule", "ClassUnconnectedToPackage")
internal class RootConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("anouar.plugins.DetektConvention")
                apply("anouar.plugins.DokkaConvention")
                apply("anouar.plugins.KotlinJvmConvention")
            }
            tasks.register<Copy>("copyGitHooks") {
                description = "Copy git hooks from the scripts to the .git/hooks folder."
                group = "git hooks"
                outputs.upToDateWhen { false }

                val hookFiles = listOf("pre-commit", "lock-main-branch", "detekt", "dokka")
                hookFiles.forEach { hook ->
                    val originFile = file("$rootDir/scripts/hooks/$hook")
                    if (originFile.exists()) {
                        from(originFile)
                    } else {
                        throw GradleException("Origin file does not exist: ${originFile.absolutePath}")
                    }
                }
                into(".git/hooks/")
            }
        }
    }
}
