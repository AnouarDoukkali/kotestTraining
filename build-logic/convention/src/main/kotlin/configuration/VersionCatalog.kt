/**
 * File: VersionCatalog.kt
 * Author: Anouar Doukkali
 * Created on:  1/22/2024 2:28 AM
 * Description: this file contains the version catalog extension
 * Since: v1.0.0
 */
package configuration

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal fun Project.versionCatalog(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")
