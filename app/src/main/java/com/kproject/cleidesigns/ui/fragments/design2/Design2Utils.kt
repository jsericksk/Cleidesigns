package com.kproject.cleidesigns.ui.fragments.design2

import com.kproject.cleidesigns.R
import com.kproject.cleidesigns.utils.Constants

object Design2Utils {

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