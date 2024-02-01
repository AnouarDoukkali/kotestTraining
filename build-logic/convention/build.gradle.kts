plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.kotlin)
    compileOnly(libs.detekt)
    compileOnly(libs.dokka)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("EmptyConventionPlugin") {
            id = "anouar.plugins.EmptyConventionPlugin"
            implementationClass = "plugins.template.EmptyConventionPlugin"
        }
        register("KotlinJvmConvention") {
            id = "anouar.plugins.KotlinJvmConvention"
            implementationClass = "plugins.jvm.KotlinJvmConvention"
        }
        register("DetektConvention") {
            id = "anouar.plugins.DetektConvention"
            implementationClass = "plugins.detekt.DetektConvention"
        }
        register("DokkaConvention") {
            id = "anouar.plugins.DokkaConvention"
            implementationClass = "plugins.dokka.DokkaConvention"
        }
        register("RootConvention") {
            id = "anouar.plugins.RootConvention"
            implementationClass = "plugins.common.RootConvention"
        }
        register("TestConvention") {
            id = "anouar.plugins.TestConvention"
            implementationClass = "plugins.kotest.KotestConvention"
        }
    }
}
