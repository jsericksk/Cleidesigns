package com.kproject.cleidesigns.utils

import com.kproject.cleidesigns.R
import com.kproject.cleidesigns.models.Design
import com.kproject.cleidesigns.ui.fragments.design2.Place
import com.kproject.cleidesigns.ui.fragments.design2.TravelBuddy

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
        designList.add(design1)
        val design2 = Design(
            image = R.drawable.design_inspiration_2,
            fragmentId = R.id.design2Fragment,
            title = "Design 2",
            sourceUrl = "https://dribbble.com/shots/10859439-Travel-App-Free",
            tags = "travel app, item details, buy"
        )
        designList.add(design2)
    }

    object Design2 {
        fun createListOfPlaces(): List<Place> {
            val list = mutableListOf<Place>()
            val place1 = Place(
                image = R.drawable.design2_image_japan,
                name = "JAPAN"
            )
            val place2 = Place(
                image = R.drawable.design2_image_barcelona,
                name = "BARCELONA"
            )
            val place3 = Place(
                image = R.drawable.design2_image_greece,
                name = "GREECE"
            )
            val place4 = Place(
                image = R.drawable.design2_image_rome,
                name = "ROME"
            )
            list.add(place1)
            list.add(place2)
            list.add(place3)
            list.add(place4)
            return list
        }

        fun createTravelBuddyList(): List<TravelBuddy> {
            val list = mutableListOf<TravelBuddy>()
            val travelBuddy1 = TravelBuddy(
                personImage = R.drawable.ic_design2_person1,
                name = "Ashok",
                age = 28,
                status = Constants.Design2.STATUS_FRIEND
            )
            val travelBuddy2 = TravelBuddy(
                personImage = R.drawable.ic_design2_person2,
                name = "Jack",
                age = 20,
                status = Constants.Design2.STATUS_FRIEND
            )
            val travelBuddy3 = TravelBuddy(
                personImage = R.drawable.ic_design2_person1,
                name = "Ekrous",
                age = 23,
                status = Constants.Design2.STATUS_UNKNOWN
            )
            list.add(travelBuddy1)
            list.add(travelBuddy2)
            list.add(travelBuddy3)
            return list
        }
    }
}