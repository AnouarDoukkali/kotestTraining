/**
 * File: KotlinJvm.kt
 * Author: Anouar Doukkali
 * Created on:  1/22/2024 2:28 AM
 * Description: this file contains kotlin jvm configuration
 * Since: v1.0.0
 */
package configuration

import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.configureKotlinJvm() {
    extensions.configure<KotlinJvmProjectExtension> {
        jvmToolchain(versionCatalog().findVersion("javaVersion").get().toString().toInt())
    }
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            val warningsAsErrors: String? by project
            allWarningsAsErrors = warningsAsErrors.toBoolean()
        }
    }
}
