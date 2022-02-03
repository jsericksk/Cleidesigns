package com.kproject.cleidesigns.ui.fragments.design2

import androidx.annotation.DrawableRes

data class TravelBuddy(
    @DrawableRes val personImage: Int,
    val name: String,
    val age: Int,
    val status: Int
)