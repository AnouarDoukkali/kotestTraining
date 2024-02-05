/**
 * File: TestingStyles.kt
 * Author: Anouar Doukkali
 * Created on: 2/5/2024 10:02 AM
 * Description:
 * Since: v0.1.0
 */
package documentation.ch2

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/** fun spec style */
internal class FunSpecStyle : FunSpec({
    // a context is a group of tests
    xcontext("a context") {
        test("a test") {
            1 + 2 shouldBe 3
        }
    }
    // tests can be disabled by using xtest or xcontext
    xtest("My first test") {
        1 + 2 shouldBe 3
    }
})

/** string spec style */
internal class StringSpecStyle : StringSpec({
    "length should return the length of the string".config(enabled = false) {
        "hello".length shouldBe 5
    }

    // disabled test in string spec style
    "disabled test".config(enabled = false) {
        "hello".length shouldBe 5
    }
})

/** should spec style */
internal class ShouldSpecStyle : ShouldSpec({
    xcontext("String.length") {
        should("return the length of the string") {
            "hello".length shouldBe 5
        }
    }
})

/** describe spec style */
internal class DescribeSpecStyle : DescribeSpec({
    xdescribe("String.length") {
        it("should return the length of the string") {
            "hello".length shouldBe 5
        }
    }
})

/** Behavior spec style */
internal class BehaviorSpecStyle : BehaviorSpec({
    Given("a string") {
        When("the length is calculated") {
            Then("it should return the length of the string") {
                "hello".length shouldBe 5
            }
        }
        xwhen("it's empty") {
            then("it return true") {
                "".isEmpty() shouldBe true
            }
        }
    }
})

/** feature spec style */
internal class FeatureSpecStyle : io.kotest.core.spec.style.FeatureSpec({
    xfeature("String.length") {
        scenario("return the length of the string") {
            "hello".length shouldBe 5
        }
        xscenario("return true if the string is empty") {
            "".isEmpty() shouldBe true
        }
    }
})
