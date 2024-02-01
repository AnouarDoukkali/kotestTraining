package convention.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

internal open class MyTask : DefaultTask() {
    @TaskAction
    fun myAction() {
        println("executing the CustomTask class ")
    }
}
