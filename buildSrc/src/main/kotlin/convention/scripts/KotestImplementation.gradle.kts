// implementing a plugin using a dedicated pre-compiled script
import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    java
}
val libs = the<LibrariesForLibs>()

dependencies {
    testImplementation(libs.kotest.runner)
    testImplementation(libs.kotest.assertion)
    testImplementation(libs.kotest.properties)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
