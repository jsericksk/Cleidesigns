package com.kproject.cleidesigns.feature.design2.model

import androidx.annotation.DrawableRes
import com.kproject.cleidesigns.feature.design2.R

internal data class TravelBuddy(
    @DrawableRes val personImage: Int,
    val name: String,
    val age: Int,
    val isFriend: Boolean
)

internal val travelBuddyList = listOf(
    TravelBuddy(
        personImage = R.drawable.ic_person1,
        name = "Ashok",
        age = 28,
        isFriend = true
    ),
    TravelBuddy(
        personImage = R.drawable.ic_person2,
        name = "Jack",
        age = 20,
        isFriend = true
    ),
    TravelBuddy(
        personImage = R.drawable.ic_person1,
        name = "Ekrous",
        age = 23,
        isFriend = false
    )
)