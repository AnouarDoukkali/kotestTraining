/**
 * File: TestOrdering.kt
 * Author: Anouar Doukkali
 * Created on: 4/19/2024 3:42 AM
 * Description:
 * Since: v0.1.0
 */
package documentation.ch6

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.TestCaseOrder
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Order

/**
 * we set spec ordering in AbstractProjectConfig
 * then we can use the order annotation before the spec
 */
@Order(1)
internal class SpecOrdering : FunSpec({
    test("ordering spec") {
        "this spec is running first".length shouldNotBe 0
    }
})

/**
 * we can also set test case ordering inside the spec by overriding testCaseOrder
 */
@Order(2)
internal class TestOrdering : StringSpec() {
    override fun testCaseOrder(): TestCaseOrder? = TestCaseOrder.Lexicographic

    init {
        "test 1" {
            "this is running first".length shouldNotBe 0
        }
        "test 2" {
            "this is running second".length shouldNotBe 0
        }
    }
}
