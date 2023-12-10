package com.kproject.cleidesigns.utils

import com.kproject.cleidesigns.R
import com.kproject.cleidesigns.presentation.main.Design

/**
 * In the future there may be many designs, so this class serves as a way to
 * decouple boilerplate code from list creation.
 */
object ListUtils {

    fun createList(): List<Design> {
        val designList = mutableListOf<Design>()
        addList1(designList)
        return designList
    }

    private fun addList1(designList: MutableList<Design>) {
        val design1 = Design(
            image = R.drawable.design_inspiration_1,
            fragmentId = R.id.design1Fragment,
            title = "Design 1",
            sourceUrl = "https://dribbble.com/shots/7046889-Wrist-Watch-App-Concept",
            tags = "wrist app, item details, buy"
        )

        val design2 = Design(
            image = R.drawable.design_inspiration_2,
            fragmentId = R.id.design2Fragment,
            title = "Design 2",
            sourceUrl = "https://dribbble.com/shots/10859439-Travel-App-Free",
            tags = "travel app"
        )
        val design3 = Design(
            image = R.drawable.design_inspiration_3,
            fragmentId = R.id.design3Fragment,
            title = "Design 3",
            sourceUrl = "https://dribbble.com/shots/17476661-ProCoin-Banking-App-Design",
            tags = "banking app, chart, statistics"
        )
        designList.add(design1)
        designList.add(design2)
        designList.add(design3)
    }
}