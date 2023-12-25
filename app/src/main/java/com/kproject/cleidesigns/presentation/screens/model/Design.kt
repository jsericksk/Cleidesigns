package com.kproject.cleidesigns.presentation.screens.model

import androidx.annotation.DrawableRes
import com.kproject.cleidesigns.R

data class Design(
    val id: Int = 1,
    @DrawableRes val image: Int = R.drawable.design_inspiration_1,
    val title: String = "Design 1",
    val sourceUrl: String = "https://dribbble.com/shots/7046889-Wrist-Watch-App-Concept",
    val tags: String = "wrist app, item details, buy"
)

enum class DesignType(@DrawableRes val iconResId: Int) {
    XML(iconResId = R.drawable.ic_density_medium),
    Compose(iconResId = R.drawable.ic_code),
    Inspiration(iconResId = R.drawable.ic_lightbulb);
}

val designs = listOf(
    Design(
        id = 1,
        image = R.drawable.design_inspiration_1,
        title = "Design 1",
        sourceUrl = "https://dribbble.com/shots/7046889-Wrist-Watch-App-Concept",
        tags = "wrist app, item details, buy"
    ),
    Design(
        id = 2,
        image = R.drawable.design_inspiration_2,
        title = "Design 2",
        sourceUrl = "https://dribbble.com/shots/10859439-Travel-App-Free",
        tags = "travel app"
    ),
    Design(
        id = 3,
        image = R.drawable.design_inspiration_3,
        title = "Design 3",
        sourceUrl = "https://dribbble.com/shots/17476661-ProCoin-Banking-App-Design",
        tags = "banking app, chart, statistics"
    ),
    Design(
        id = 4,
        image = R.drawable.design_inspiration_4,
        title = "Design 4",
        sourceUrl = "https://dribbble.com/shots/4395258-Dribble",
        tags = "login screen"
    )
)