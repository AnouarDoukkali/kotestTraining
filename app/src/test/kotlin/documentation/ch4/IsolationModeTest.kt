/**
 * File: IsolationModeTest.kt
 * Author: Anouar Doukkali
 * Created on: 3/7/2024 12:27 PM
 * Description:
 * Since: v0.1.0
 */
package documentation.ch4

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.util.*

/** the default isolation mode is IsolationMode.SingleInstance

 * here ,we are specifying the isolation mode directly in the test class

 * we could also set the isolation mode as system property or in wide project config
 */

internal class IsolationModeTest : FunSpec({
    isolationMode = IsolationMode.InstancePerLeaf
    val id = UUID.randomUUID()
    context("instance per leaf") {
        test("test 1") {
            println("test 1 id: $id")
            1 shouldBe 1
        }
        test("test 2") {
            println("test 2 id: $id")
            1 shouldBe 1
        }
    }

    test("test 3") {
        println("test 3 id: $id")
        1 shouldBe 1
    }
})
