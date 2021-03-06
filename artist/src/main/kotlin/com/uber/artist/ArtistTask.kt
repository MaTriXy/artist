/*
 * Copyright (C) 2017. Uber Technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uber.artist

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.incremental.IncrementalTaskInputs
import java.io.File

open class ArtistTask : DefaultTask() {

    @Input
    lateinit var outputDirectory: File

    @Input
    lateinit var packageName: String

    @Input
    lateinit var viewPackageName: String

    @Input
    var superinterfaceClassName: String? = null

    @Input
    var viewNamePrefix: String = ""

    @Input
    var formatSource: Boolean = true

    @TaskAction
    fun execute(inputs: IncrementalTaskInputs) {
        generateViewsFor(outputDirectory, packageName, viewPackageName, superinterfaceClassName, viewNamePrefix, formatSource)
    }
}
