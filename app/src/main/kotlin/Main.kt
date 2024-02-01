import io.github.oshai.kotlinlogging.KotlinLogging
/**
 * File: Main.kt
 * Author: Anouar Doukkali
 * Created on: 1/28/2024 12:14 AM
 * Description:
 * Since: v1.0.0
 */

private val log = KotlinLogging.logger {}

internal fun main() {
    println("Hello World!")
    log.info { "hello from logger " }
}
