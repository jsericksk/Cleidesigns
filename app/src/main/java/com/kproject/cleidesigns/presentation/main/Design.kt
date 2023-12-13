package com.kproject.cleidesigns.presentation.main

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import com.kproject.cleidesigns.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Design(
    @DrawableRes val image: Int,
    @IdRes val fragmentId: Int = 0,
    val title: String,
    val sourceUrl: String,
    val tags: String
) : Parcelable