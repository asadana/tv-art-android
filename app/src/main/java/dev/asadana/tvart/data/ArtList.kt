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

package dev.asadana.tvart.data

object ArtList {
    val ART_CATEGORY = arrayOf(
        "Abstract",
        "Landscape"
    )

    val list: List<Art> by lazy {
        setupArtList()
    }
    private var count: Long = 0

    private fun setupArtList(): List<Art> {
        val title = arrayOf(
            "Title 1",
            "Title 2",
            "Title 3",
            "Title 4",
            "Title 5"
        )

        val description = "Description placeholder"

        val fullImageUrl = arrayOf(
            "https://cdn.pixabay.com/photo/2017/03/09/22/07/abstract-tree-2130991_960_720.jpg",
            "https://cdn.pixabay.com/photo/2016/09/17/17/05/digital-art-1676531_960_720.jpg",
            "https://cdn.pixabay.com/photo/2020/02/10/18/46/animal-4837384_960_720.jpg",
            "https://cdn.pixabay.com/photo/2017/07/03/20/17/colorful-2468874_960_720.jpg",
            "https://cdn.pixabay.com/photo/2015/12/27/21/11/beach-1110498_960_720.jpg",
            "https://cdn.pixabay.com/photo/2017/12/10/15/16/white-horse-3010129_960_720.jpg",
            "https://cdn.pixabay.com/photo/2021/09/28/14/39/horse-6664660_960_720.jpg",
            "https://cdn.pixabay.com/photo/2016/08/09/23/54/dogs-1582195_960_720.jpg"
        )
        val bgImageUrl = arrayOf(
            "https://cdn.pixabay.com/photo/2017/03/09/22/07/abstract-tree-2130991_960_720.jpg",
            "https://cdn.pixabay.com/photo/2016/09/17/17/05/digital-art-1676531_960_720.jpg",
            "https://cdn.pixabay.com/photo/2020/02/10/18/46/animal-4837384_960_720.jpg",
            "https://cdn.pixabay.com/photo/2017/07/03/20/17/colorful-2468874_960_720.jpg",
            "https://cdn.pixabay.com/photo/2015/12/27/21/11/beach-1110498_960_720.jpg",
            "https://cdn.pixabay.com/photo/2017/12/10/15/16/white-horse-3010129_960_720.jpg",
            "https://cdn.pixabay.com/photo/2021/09/28/14/39/horse-6664660_960_720.jpg",
            "https://cdn.pixabay.com/photo/2016/08/09/23/54/dogs-1582195_960_720.jpg"
        )
        val cardImageUrl = arrayOf(
            "https://cdn.pixabay.com/photo/2017/03/09/22/07/abstract-tree-2130991_960_720.jpg",
            "https://cdn.pixabay.com/photo/2016/09/17/17/05/digital-art-1676531_960_720.jpg",
            "https://cdn.pixabay.com/photo/2020/02/10/18/46/animal-4837384_960_720.jpg",
            "https://cdn.pixabay.com/photo/2017/07/03/20/17/colorful-2468874_960_720.jpg",
            "https://cdn.pixabay.com/photo/2015/12/27/21/11/beach-1110498_960_720.jpg",
            "https://cdn.pixabay.com/photo/2017/12/10/15/16/white-horse-3010129_960_720.jpg",
            "https://cdn.pixabay.com/photo/2021/09/28/14/39/horse-6664660_960_720.jpg",
            "https://cdn.pixabay.com/photo/2016/08/09/23/54/dogs-1582195_960_720.jpg"
        )

        val list = title.indices.map {
            buildArtInfo(
                title[it],
                description,
                fullImageUrl[it],
                cardImageUrl[it],
                bgImageUrl[it]
            )
        }

        return list
    }

    private fun buildArtInfo(
        title: String,
        description: String,
        fullImageUrl: String,
        cardImageUrl: String,
        backgroundImageUrl: String
    ): Art {
        val artObj = Art()
        artObj.id = count++
        artObj.title = title
        artObj.description = description
        artObj.cardImageUrl = cardImageUrl
        artObj.backgroundImageUrl = backgroundImageUrl
        artObj.fullImageUrl = fullImageUrl
        return artObj
    }
}