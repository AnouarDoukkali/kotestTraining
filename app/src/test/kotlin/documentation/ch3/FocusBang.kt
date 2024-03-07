/**
 * File: FocusBang.kt
 * Author: Anouar Doukkali
 * Created on: 2/5/2024 1:26 PM
 * Description:
 * Since: v0.1.0
 */
package documentation.ch3

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * focus mode is a way to run only the tests that are focused,
 */
internal class FocusExample : StringSpec({
    "this test will be skipped even if it fails" {
        true shouldBe false
    }
    "f:this test is focused" {
        true shouldBe true
    }
})

/**
 * Bang mode is a way to skip a test
 */
internal class BangExample : StringSpec({
    "!this test will be skipped" {
        true shouldBe false
    }

    "this test will be executed" {
        true shouldBe true
    }
})
