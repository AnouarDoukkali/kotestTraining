/**
 * File: Dokka.kt
 * Author: Anouar Doukkali
 * Created on:  1/22/2024 2:12 AM
 * Description: this file contains Dokka configuration
 * Since: v1.0.0
 */
package configuration

import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.dokka.DokkaConfiguration.Visibility
import org.jetbrains.dokka.gradle.DokkaMultiModuleTask
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.dokka.gradle.DokkaTaskPartial
import org.jetbrains.dokka.gradle.GradleDokkaSourceSetBuilder

private const val WARNING_MESSAGE = "Dokka Plugin is not compatible with configuration cache."

internal fun Project.configureDokka() {
    tasks.withType<DokkaMultiModuleTask>().configureEach {
        notCompatibleWithConfigurationCache(WARNING_MESSAGE)
        outputDirectory.set(layout.buildDirectory.dir("Documentation"))
        moduleName.set("Kotlin Books Documentation")
    }
    tasks.withType<DokkaTask>().configureEach {
        notCompatibleWithConfigurationCache(WARNING_MESSAGE)
    }
    subprojects {
        tasks.withType<DokkaTaskPartial>().configureEach {
            notCompatibleWithConfigurationCache(WARNING_MESSAGE)
            outputDirectory.set(layout.buildDirectory.dir("Partial Documentation"))
            dokkaSourceSets.configureEach {
                documentedVisibilities.set(
                    setOf(
                        Visibility.INTERNAL,
                        Visibility.PUBLIC,
                        Visibility.PRIVATE,
                        Visibility.PROTECTED,
                    )
                )
                setDokkaPackageDocFileName(this@subprojects, this)
                skipEmptyPackages.set(true)
                skipDeprecated.set(false)
                suppressInheritedMembers.set(false)
                reportUndocumented.set(false)
                failOnWarning.set(false)
            }
        }
    }
}

/**
 * this function is used to set the package documentation file name for Dokka
 */
private fun setDokkaPackageDocFileName(
    project: Project,
    gradleDokkaSourceSetBuilder: GradleDokkaSourceSetBuilder
) {
    val file = project.file("README.md")
    if (file.exists().not()) {
        file.createNewFile()
    }
    gradleDokkaSourceSetBuilder.includes.from(file)
}
