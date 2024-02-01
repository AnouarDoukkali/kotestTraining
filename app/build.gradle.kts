plugins {
    id(libs.plugins.dokka.get().pluginId)
    id("anouar.plugins.KotlinJvmConvention")
    id("anouar.plugins.TestConvention")
    application
}

dependencies {
    implementation(libs.bundles.logging)
}

application {
    mainClass.set("MainKt")
}
