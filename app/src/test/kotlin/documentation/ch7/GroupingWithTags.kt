/**
 * File: GroupingWithTags.kt
 * Author: Anouar Doukkali
 * Created on: 4/19/2024 4:31 AM
 * Description:
 * Since: v0.1.0
 */
package documentation.ch7

import io.kotest.core.annotation.Tags
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import tags.Linux
import tags.MacOS
import tags.UnitTest
import tags.Windows

/**
 * to use tags in kotest , we have first to modify test task in gradle.
 * then define our tags in a specific package if needed
 * then we execute our tests with : test -Dkotest.tags="Windows"
 */
internal class MyTestClass : FunSpec({
    /** *
     * tag the whole spec with the tag Windows
     */
    tags(Windows)
    // this test is already tagged with windows
    test("test 1").config(tags = setOf(Linux)) {
        1 shouldBe 1
    }
    // this test is already tagged with windows
    test("test 2").config(tags = setOf(MacOS)) {
        1 shouldBe 1
    }
})

/**
 * we can also tag the whole spec with a tag using annotation
 */
@Tags("Android")
internal class AnnotationTagClass : FunSpec({
    // spec is tagged with Android then all tests are tagged with UnitTest
    tags(UnitTest)

    fun test1() {
        1 shouldBe 1
    }
})
