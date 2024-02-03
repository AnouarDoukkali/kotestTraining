/**
 * File: WtiringTests.kt
 * Author: Anouar Doukkali
 * Created on: 2/3/2024 9:06 AM
 * Description:
 * Since: v0.1.0
 */
package documentation.ch1

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.shouldBe

/**
 * This is a simple test class
 */
internal class WritingTests : FunSpec({
    test("My first test") {
        1 + 2 shouldBe 3
    }
})

/**
 * Nested Tests
 */
internal class NestedTestExample : DescribeSpec({
    describe("an outer test") {
        it("an inner test") {
            1 + 2 shouldBe 3
        }
        it("another inner test") {
            1 + 2 shouldBe 3
        }
    }
})

/**
 * Dynamic test class, this will be converted to a test class with 3 tests at runtime :
 *
 * test("the number 1"){
 *  1 shouldBeLessThan 5
 * }
 *
 * test("the number 2"){
 * 2 shouldBeLessThan 5
 * }
 *
 * test("the number 3"){
 * 3 shouldBeLessThan 5
 *  }
 */
internal class DynamicTest : FunSpec({
    listOf(1, 2, 3).forEach {
        test("the number $it") {
            it shouldBeLessThan 5
        }
    }
})

/**
 * Lifecycle Callbacks can be reused across multiple test classes
 */
internal class ReusableCallbacks : FunSpec({

    beforeEach {
        println("Before  each test")
    }
    beforeSpec {
        println("Before the whole spec")
    }

    test("test 1") {
        1 + 9 shouldBe 10
    }
    test("test 2") {
        5 + 7
    }
})
