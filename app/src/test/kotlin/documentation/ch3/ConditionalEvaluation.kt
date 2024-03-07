/**
 * File: ConditionalEvaluation.kt
 * Author: Anouar Doukkali
 * Created on: 2/5/2024 12:22 PM
 * Description:
 * Since: v0.1.0
 */
package documentation.ch3

import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.Enabled
import io.kotest.core.test.EnabledIf
import io.kotest.core.test.TestCase
import io.kotest.matchers.shouldBe

/** Enabled Flags */
internal class EnabledFlags : StringSpec({
    "Enabled test".config(enabled = true) {
        1 + 6 shouldBe 7
    }
    "Enabled if os is linux".config(enabled = System.getProperty("os.name").contains("Linux")) {
        1 + 6 shouldBe 7
    }
})

private val disablingDanger: EnabledIf = {
    it.name.testName.contains("danger")
}

/** Enabled if*/
internal class EnabledIF : StringSpec({
    "danger test".config(enabledIf = disablingDanger) {
        1 + 8 shouldBe 9
    }
    "safe test".config(enabledIf = disablingDanger) {
        1 + 8 shouldBe 9
    }
})

private val enabledIfReason: (TestCase) -> Enabled = {
    if (it.name.testName.startsWith("danger")) {
        Enabled.disabled("can't run this")
    } else {
        Enabled.enabled
    }
}

/** Enabled if of reason */
internal class EnabledIFReason : StringSpec({
    "danger enabled or reason if test".config(enabledOrReasonIf = enabledIfReason) {
        1 + 8 shouldBe 9
    }

    "safe enabled or reason if test".config(enabledOrReasonIf = enabledIfReason) {
        1 + 8 shouldBe 9
    }
})
