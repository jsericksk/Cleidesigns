package com.kproject.cleidesigns.models

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes

data class Design(
    @DrawableRes val image: Int,
    @IdRes val fragmentId: Int = 0,
    val title: String,
    val sourceUrl: String,
    val tags: String
)