package com.kproject.cleidesigns.presentation.screens.model

import androidx.annotation.DrawableRes
import com.kproject.cleidesigns.R
import com.kproject.cleidesigns.presentation.main.Design

data class Design(
    @DrawableRes val image: Int,
    val title: String,
    val sourceUrl: String,
    val tags: String
)

enum class DesignType {
    XML,
    Compose,
    Inspiration
}

val designs = listOf(
    Design(
        image = R.drawable.design_inspiration_1,
        title = "Design 1",
        sourceUrl = "https://dribbble.com/shots/7046889-Wrist-Watch-App-Concept",
        tags = "wrist app, item details, buy"
    ),
    Design(
        image = R.drawable.design_inspiration_2,
        title = "Design 2",
        sourceUrl = "https://dribbble.com/shots/10859439-Travel-App-Free",
        tags = "travel app"
    ),
    Design(
        image = R.drawable.design_inspiration_3,
        title = "Design 3",
        sourceUrl = "https://dribbble.com/shots/17476661-ProCoin-Banking-App-Design",
        tags = "banking app, chart, statistics"
    )
)