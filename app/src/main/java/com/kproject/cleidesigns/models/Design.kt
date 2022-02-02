package com.kproject.cleidesigns.models

import androidx.annotation.DrawableRes

data class Design(
    @DrawableRes val image: Int,
    val title: String,
    val sourceUrl: String,
    val tags: String
)