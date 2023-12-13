package com.kproject.cleidesigns.utils

import com.kproject.cleidesigns.R
import com.kproject.cleidesigns.presentation.main.DesignXML

/**
 * In the future there may be many designs, so this class serves as a way to
 * decouple boilerplate code from list creation.
 */
object ListUtils {

    fun createList(): List<DesignXML> {
        val designList = mutableListOf<DesignXML>()
        addList1(designList)
        return designList
    }

    private fun addList1(designList: MutableList<DesignXML>) {
        val design1 = DesignXML(
            image = R.drawable.design_inspiration_1,
            fragmentId = R.id.design1Fragment,
            title = "DesignXML 1",
            sourceUrl = "https://dribbble.com/shots/7046889-Wrist-Watch-App-Concept",
            tags = "wrist app, item details, buy"
        )
        val design2 = DesignXML(
            image = R.drawable.design_inspiration_2,
            fragmentId = R.id.design2Fragment,
            title = "DesignXML 2",
            sourceUrl = "https://dribbble.com/shots/10859439-Travel-App-Free",
            tags = "travel app"
        )
        val design3 = DesignXML(
            image = R.drawable.design_inspiration_3,
            fragmentId = R.id.design3Fragment,
            title = "DesignXML 3",
            sourceUrl = "https://dribbble.com/shots/17476661-ProCoin-Banking-App-Design",
            tags = "banking app, chart, statistics"
        )
        designList.add(design1)
        designList.add(design2)
        designList.add(design3)
    }
}