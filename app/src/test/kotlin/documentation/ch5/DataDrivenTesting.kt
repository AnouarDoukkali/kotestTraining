/**
 * File: DataDrivenTesting.kt
 * Author: Anouar Doukkali
 * Created on: 4/19/2024 12:59 AM
 * Description:
 * Since: v0.1.0
 */
package documentation.ch5

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

/**
 * Data class to hold two numbers
 * @property a first number
 * @property b second number
 */
internal data class Numbers(val a: Int, val b: Int)

/**
 * Function to check if the sum of two numbers is positive
 * @param a first number
 * @param b second number
 */
private fun isSumPositive(a: Int, b: Int): Boolean {
    return a + b > 0
}

/**
 * Test class for data-driven testing
 * @see Numbers
 */
internal class DataDrivenTesting : FunSpec({
    context("sum of two numbers should be positive") {
        withData(
            Numbers(7, 1),
            Numbers(5, 6),
            Numbers(8, 4),
        ) { (a, b) ->
            isSumPositive(a, b) shouldBe true
        }
    }
})
