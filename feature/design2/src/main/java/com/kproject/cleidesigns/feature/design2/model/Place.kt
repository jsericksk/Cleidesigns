package com.kproject.cleidesigns.feature.design2.model

import androidx.annotation.DrawableRes
import com.kproject.cleidesigns.feature.design2.R

internal data class Place(
    @DrawableRes val image: Int,
    val name: String
)

internal val placeList = listOf(
    Place(
        image = R.drawable.img_japan,
        name = "JAPAN"
    ), Place(
        image = R.drawable.img_barcelona,
        name = "BARCELONA"
    ), Place(
        image = R.drawable.img_greece,
        name = "GREECE"
    ), Place(
        image = R.drawable.img_rome,
        name = "ROME"
    )
)