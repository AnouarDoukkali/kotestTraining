/**
 * File: TestExample.kt
 * Author: Anouar Doukkali
 * Created on: 1/28/2024 12:02 AM
 * Description:
 * Since: v1.0.0
 */
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class TestExample : FunSpec(
    {
        test("test example") {
            1 + 9 shouldBe 10
        }
    }
)
