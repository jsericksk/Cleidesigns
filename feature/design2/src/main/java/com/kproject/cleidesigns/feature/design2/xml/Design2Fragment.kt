package com.kproject.cleidesigns.feature.design2.xml

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.kproject.cleidesigns.feature.design2.databinding.FragmentDesign2Binding
import com.kproject.cleidesigns.feature.design2.model.placeList
import com.kproject.cleidesigns.feature.design2.model.travelBuddyList
import com.kproject.cleidesigns.feature.design2.xml.adapter.ListOfPlacesAdapter
import com.kproject.cleidesigns.feature.design2.xml.adapter.TravelBuddyListAdapter

fun Fragment.initializeFragmentLayout(): ViewBinding {
    val binding = FragmentDesign2Binding.inflate(layoutInflater)

    // RecyclerView of list of places
    val layoutManager1 = GridLayoutManager(requireContext(), 2)
    val listOfPlacesAdapter = ListOfPlacesAdapter(
        listOfPlaces = placeList, onItemClickListener = { place -> }
    )
    binding.rvListOfPlaces.adapter = listOfPlacesAdapter
    binding.rvListOfPlaces.layoutManager = layoutManager1

    // RecyclerView of travel buddy list
    val layoutManager2 = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    val travelBuddyListAdapter = TravelBuddyListAdapter(
        travelBuddyList, onItemClickListener = { travelBuddy -> }
    )
    binding.rvTravelBuddyList.adapter = travelBuddyListAdapter
    binding.rvTravelBuddyList.layoutManager = layoutManager2

    return binding
}