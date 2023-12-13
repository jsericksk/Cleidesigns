package com.kproject.cleidesigns.presentation.screens.model

import androidx.annotation.DrawableRes
import com.kproject.cleidesigns.R

data class Design(
    @DrawableRes val image: Int = R.drawable.design_inspiration_1,
    val title: String = "Design 1",
    val sourceUrl: String = "https://dribbble.com/shots/7046889-Wrist-Watch-App-Concept",
    val tags: String = "wrist app, item details, buy"
)

enum class DesignType {
    XML,
    Compose,
    Inspiration
}

val designs = listOf(
    Design(
        image = R.drawable.design_inspiration_1,
        title = "DesignXML 1",
        sourceUrl = "https://dribbble.com/shots/7046889-Wrist-Watch-App-Concept",
        tags = "wrist app, item details, buy"
    ),
    Design(
        image = R.drawable.design_inspiration_2,
        title = "DesignXML 2",
        sourceUrl = "https://dribbble.com/shots/10859439-Travel-App-Free",
        tags = "travel app"
    ),
    Design(
        image = R.drawable.design_inspiration_3,
        title = "DesignXML 3",
        sourceUrl = "https://dribbble.com/shots/17476661-ProCoin-Banking-App-Design",
        tags = "banking app, chart, statistics"
    )
)