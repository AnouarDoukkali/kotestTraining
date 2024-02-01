plugins {
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.dokka) apply false
    id("anouar.plugins.RootConvention")
}

group = "org.anouar.kotlinBooks"
version = "v0.1.0"
description = "new kotlin project template"
