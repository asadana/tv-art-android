/*
 * TV Art: An Android TV app that allows a user to show selectable art.
 * Copyright (C) 2021  Ankit Sadana
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package dev.asadana.tvart

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class DisplayArtActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_art)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.display_art_fragment, DisplayArtFragment())
                .commitNow()
        }
    }

    companion object {
        const val ART = "Art"
        const val SHARED_ELEMENT_NAME = "hero"
    }
}