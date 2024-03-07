/**
 * File: SpecAnnotation.kt
 * Author: Anouar Doukkali
 * Created on: 2/8/2024 3:42 PM
 * Description:
 * Since: v0.1.0
 */
package documentation.ch3

import io.kotest.core.annotation.Ignored
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * Ignoring a test using the @Ignored annotation
 */
@Ignored
internal class SpecAnnotation : FunSpec({
    test("this test will be ignored ") {
        true shouldBe false
    }
})
