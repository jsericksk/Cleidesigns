package com.kproject.cleidesigns.presentation.main

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class DesignXML(
    @DrawableRes val image: Int,
    @IdRes val fragmentId: Int = 0,
    val title: String,
    val sourceUrl: String,
    val tags: String
) : Parcelable