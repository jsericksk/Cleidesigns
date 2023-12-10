package com.kproject.cleidesigns.presentation.fragments.design2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import com.kproject.cleidesigns.R
import com.kproject.cleidesigns.databinding.Design2RecyclerviewItemPlaceBinding
import com.kproject.cleidesigns.databinding.Design2RecyclerviewItemTravelBuddyBinding
import com.kproject.cleidesigns.databinding.FragmentDesign2Binding
import com.kproject.cleidesigns.presentation.fragments.BaseFragment
import com.kproject.cleidesigns.utils.Constants

class Design2Fragment : BaseFragment() {

    override fun initializeXmlLayout(): ViewBinding {
        val binding = FragmentDesign2Binding.inflate(layoutInflater)
        val listOfPlaces = Design2Utils.createListOfPlaces()
        val travelBuddyList = Design2Utils.createTravelBuddyList()

        // RecyclerView of list of places
        val layoutManager1 = GridLayoutManager(requireContext(), 2)
        val listOfPlacesAdapter = ListOfPlacesAdapter(
            listOfPlaces, onItemClickListener = { place -> }
        )
        binding.rvListOfPlaces.adapter = listOfPlacesAdapter
        binding.rvListOfPlaces.layoutManager = layoutManager1

        // RecyclerView of travel buddy list
        val layoutManager2 =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val travelBuddyListAdapter = TravelBuddyListAdapter(
            travelBuddyList, onItemClickListener = { travelBuddy -> }
        )
        binding.rvTravelBuddyList.adapter = travelBuddyListAdapter
        binding.rvTravelBuddyList.layoutManager = layoutManager2

        return binding
    }

    @Composable
    override fun ComposeLayout() = Design2Compose()

    /**
     * Used in XML version.
     */
    inner class ListOfPlacesAdapter(
        private val listOfPlaces: List<Place>,
        private val onItemClickListener: ((place: Place) -> Unit)
    ) : RecyclerView.Adapter<ListOfPlacesAdapter.ItemViewHolder>() {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            view: Int
        ): ItemViewHolder {
            val binding = Design2RecyclerviewItemPlaceBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemViewHolder(binding)
        }

        override fun getItemCount() = listOfPlaces.size

        override fun onBindViewHolder(
            viewHolder: ItemViewHolder,
            position: Int
        ) {
            viewHolder.bindView(listOfPlaces[position])
        }

        inner class ItemViewHolder(
            private val binding: Design2RecyclerviewItemPlaceBinding
        ) : RecyclerView.ViewHolder(binding.root) {

            fun bindView(place: Place) {
                with(binding) {
                    tvName.text = place.name
                    ivImage.load(place.image)
                }

                itemView.setOnClickListener {
                    onItemClickListener(place)
                }
            }
        }
    }

    /**
     * Used in XML version.
     */
    inner class TravelBuddyListAdapter(
        private val travelBuddyList: List<TravelBuddy>,
        private val onItemClickListener: ((travelBuddy: TravelBuddy) -> Unit)
    ) : RecyclerView.Adapter<TravelBuddyListAdapter.ItemViewHolder>() {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            view: Int
        ): ItemViewHolder {
            val binding = Design2RecyclerviewItemTravelBuddyBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemViewHolder(binding)
        }

        override fun getItemCount() = travelBuddyList.size

        override fun onBindViewHolder(
            viewHolder: ItemViewHolder,
            position: Int
        ) {
            viewHolder.bindView(travelBuddyList[position], position)
        }

        inner class ItemViewHolder(
            private val binding: Design2RecyclerviewItemTravelBuddyBinding
        ) : RecyclerView.ViewHolder(binding.root) {

            fun bindView(travelBuddy: TravelBuddy, position: Int) {
                with(binding) {
                    if ((position % 2) == 0) {
                        cvMainCardView.setCardBackgroundColor(
                            ContextCompat.getColor(requireContext(), R.color.cardview_background1)
                        )
                    } else {
                        cvMainCardView.setCardBackgroundColor(
                            ContextCompat.getColor(requireContext(), R.color.cardview_background2)
                        )
                    }

                    tvName.text = travelBuddy.name
                    tvAge.text = travelBuddy.age.toString()
                    val status = travelBuddy.status
                    if (status == Constants.Design2.STATUS_FRIEND) {
                        tvStatus.text = "Friend"
                    } else if (status == Constants.Design2.STATUS_UNKNOWN) {
                        tvStatus.text = "Unknown"
                    }
                    ivPersonImage.load(travelBuddy.personImage)
                }

                itemView.setOnClickListener {
                    onItemClickListener(travelBuddy)
                }
            }
        }
    }
}
