/**
 * File: Xmethods.kt
 * Author: Anouar Doukkali
 * Created on: 2/8/2024 3:39 PM
 * Description:
 * Since: v0.1.0
 */
package documentation.ch3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class XMethods : FunSpec({
    xtest("this test will be skipped") {
        true shouldBe false
    }
    test("this test will be executed") {
        true shouldBe true
    }
})
