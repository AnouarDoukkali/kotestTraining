/**
 * File: Detekt.kt
 * Author: Anouar Doukkali
 * Created on:  1/22/2024 2:12 AM
 * Description: this file contains Detekt configuration
 * Since: v1.0.0
 */
package configuration

import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType

internal fun Project.configureDetekt(extension: DetektExtension) =
    extension.apply {
        parallel = true
        autoCorrect = true
        config.setFrom("config/detekt/detekt.yml")
        baseline = file("config/detekt/baseline.xml")
        source.setFrom(setOf(rootDir, "$rootDir/build-logic", "$rootDir/buildSrc"))
        tasks.withType<Detekt> {
            exclude(listOf("**/resources/**", "**/build/**", "**/.*/**"))
            include(listOf("**/*.kt", "**/*.kts"))
        }
        dependencies {
            add("detektPlugins", versionCatalog().findBundle("detekt").get())
        }
    }
