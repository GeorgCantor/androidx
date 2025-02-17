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

package androidx.credentials.registry.digitalcredentials.mdoc

import android.graphics.Bitmap
import androidx.credentials.registry.provider.digitalcredentials.VerificationEntryDisplayData
import androidx.credentials.registry.provider.digitalcredentials.VerificationFieldDisplayData
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class MdocEntryTest {
    companion object {
        val ENTRY_DISPLAY_DATA =
            VerificationEntryDisplayData(
                title = "test-title",
                subtitle = "test-subtitle",
                icon = Bitmap.createBitmap(4, 4, Bitmap.Config.ALPHA_8)
            )
    }

    @Test
    fun construction_success() {
        val mdocField1 =
            MdocField(
                "fieldName1",
                "fieldVal1",
                setOf(VerificationFieldDisplayData("displayName1"))
            )
        val mdocField2 =
            MdocField("fieldName2", null, setOf(VerificationFieldDisplayData("displayName2")))

        val entry =
            MdocEntry(
                docType = "org.iso.18013.5.1.mDL",
                fields = listOf(mdocField1, mdocField2),
                entryDisplayData = setOf(ENTRY_DISPLAY_DATA),
                id = "id"
            )

        assertThat(entry.docType).isEqualTo("org.iso.18013.5.1.mDL")
        assertThat(entry.fields).containsExactly(mdocField1, mdocField2).inOrder()
        assertThat(entry.entryDisplayData).containsExactly(ENTRY_DISPLAY_DATA)
        assertThat(entry.id).isEqualTo("id")
    }
}
