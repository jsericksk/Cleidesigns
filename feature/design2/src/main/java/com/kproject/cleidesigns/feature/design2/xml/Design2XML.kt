package com.kproject.cleidesigns.feature.design2.xml

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kproject.cleidesigns.feature.design2.databinding.FragmentDesign2Binding
import com.kproject.cleidesigns.feature.design2.model.placeList
import com.kproject.cleidesigns.feature.design2.model.travelBuddyList
import com.kproject.cleidesigns.feature.design2.xml.adapter.ListOfPlacesAdapter
import com.kproject.cleidesigns.feature.design2.xml.adapter.TravelBuddyListAdapter

@Composable
internal fun Design2XML() {
    val context = LocalContext.current
    AndroidViewBinding(FragmentDesign2Binding::inflate) {
        // RecyclerView of list of places
        val layoutManager1 = GridLayoutManager(context, 2)
        val listOfPlacesAdapter = ListOfPlacesAdapter(
            listOfPlaces = placeList, onItemClickListener = { place -> }
        )
        rvListOfPlaces.adapter = listOfPlacesAdapter
        rvListOfPlaces.layoutManager = layoutManager1

        // RecyclerView of travel buddy list
        val layoutManager2 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val travelBuddyListAdapter = TravelBuddyListAdapter(
            travelBuddyList, onItemClickListener = { travelBuddy -> }
        )
        rvTravelBuddyList.adapter = travelBuddyListAdapter
        rvTravelBuddyList.layoutManager = layoutManager2
    }
}