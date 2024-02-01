/**
 * File: KotestConfig.kt
 * Author: Anouar Doukkali
 * Created on: 1/27/2024 5:18 AM
 * Description:
 * Since: v1.0.0
 */
package configuration

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.test.AssertionMode

internal object KotestConfig : AbstractProjectConfig() {
    override val parallelism: Int = 3
    override val assertionMode: AssertionMode = AssertionMode.Error
    override val testNameAppendTags: Boolean = true
}
