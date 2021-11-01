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

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.leanback.app.BrandedSupportFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.transition.Transition
import dev.asadana.tvart.data.Art

class DisplayArtFragment : BrandedSupportFragment() {

    private lateinit var artImageView: ImageView
    private lateinit var selectedArt: Art

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.display_art_layout, container, false);
        selectedArt = activity?.intent?.getSerializableExtra(DisplayArtActivity.ART) as Art

        artImageView = root.findViewById<ImageView>(R.id.display_art_image) as ImageView
        updateArtView(selectedArt)
        return root
    }

    private fun updateArtView(art: Art?) {
        Log.i(TAG, "updateArtView: ")
        Glide.with(this)
            .asBitmap()
            .error(R.drawable.default_background)
            .centerCrop()
            .load(art?.fullImageUrl)
            .into(object: CustomViewTarget<ImageView, Bitmap>(artImageView) {
                override fun onLoadFailed(errorDrawable: Drawable?) {
                }

                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    Log.i(TAG, "onResourceReady: Loading image successfully.")
                    artImageView.setImageBitmap(resource)
                }

                override fun onResourceCleared(placeholder: Drawable?) {
                }
            })
    }

    companion object {
        private const val TAG = "DisplayArtFragment"
    }
}