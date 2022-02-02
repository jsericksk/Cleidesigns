package com.kproject.cleidesigns.utils

import com.kproject.cleidesigns.R
import com.kproject.cleidesigns.models.Design

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

    private fun addList1(designList: MutableList<Design>)  {
        val design1 = Design(
            image = R.drawable.inspiration_design1,
            title = "Design 1",
            sourceUrl = "https://dribbble.com/shots/7046889-Wrist-Watch-App-Concept",
            tags = "wrist app, item details, buy"
        )
        designList.add(design1)
    }
}