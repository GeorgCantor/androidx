/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.benchmark.macro.junit4

import androidx.benchmark.Arguments
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class PayloadArgumentsTest {
    @Test
    fun checkPayloadArguments() {
        // these values are set in the build.gradle file.
        assertThat(Arguments.payload)
            .containsExactlyEntriesIn(
                mapOf(
                    "simpleValue" to "simple value",
                    "xmlValue" to "<h1>some xml & reserved characters!</h1>"
                )
            )
    }
}
