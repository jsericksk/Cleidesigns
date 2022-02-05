package com.kproject.cleidesigns.ui.fragments.design2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kproject.cleidesigns.R
import com.kproject.cleidesigns.databinding.Design2RecyclerviewItemPlaceBinding
import com.kproject.cleidesigns.databinding.Design2RecyclerviewItemTravelBuddyBinding
import com.kproject.cleidesigns.databinding.FragmentDesign2Binding
import com.kproject.cleidesigns.models.Design
import com.kproject.cleidesigns.ui.ViewInspiration
import com.kproject.cleidesigns.ui.fragments.FragmentBaseInterface
import com.kproject.cleidesigns.utils.Constants

class Design2Fragment : Fragment(), FragmentBaseInterface {
    private var _binding: FragmentDesign2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val design = arguments?.getParcelable<Design>("design")!!
        val layoutVersion = arguments?.getInt("layoutVersion")
        return initializeLayout(design, layoutVersion, inflater, container)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun initializeLayout(
        design: Design,
        layoutVersion: Int?,
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View {
        lateinit var view: View
        when (layoutVersion) {
            Constants.VIEW_IN_XML -> {
                view = initializeXmlLayout(inflater, container)
            }
            Constants.VIEW_IN_COMPOSE -> {
                view = initializeComposeLayout()
            }
            Constants.VIEW_INSPIRATION -> {
                view = initializeViewInspirationLayout(design)
            }
        }
        return view
    }

    override fun initializeXmlLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View {
        _binding = FragmentDesign2Binding.inflate(inflater, container, false)
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
        val layoutManager2 = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val travelBuddyListAdapter = TravelBuddyListAdapter(
            travelBuddyList, onItemClickListener = { travelBuddy -> }
        )
        binding.rvTravelBuddyList.adapter = travelBuddyListAdapter
        binding.rvTravelBuddyList.layoutManager = layoutManager2
        return binding.root
    }

    override fun initializeComposeLayout(): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    Design2Compose()
                }
            }
        }
    }

    override fun initializeViewInspirationLayout(design: Design): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    ViewInspiration(
                        design = design,
                        navigateBack = {
                            findNavController().popBackStack(
                                R.id.homeFragment,
                                false
                            )
                        }
                    )
                }
            }
        }
    }

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
        ): ListOfPlacesAdapter.ItemViewHolder {
            val binding = Design2RecyclerviewItemPlaceBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemViewHolder(binding)
        }

        override fun getItemCount() = listOfPlaces.size

        override fun onBindViewHolder(
            viewHolder: ListOfPlacesAdapter.ItemViewHolder,
            position: Int
        ) {
            viewHolder.bindView(listOfPlaces[position])
        }

        inner class ItemViewHolder(
            private val binding: Design2RecyclerviewItemPlaceBinding
        ) : RecyclerView.ViewHolder(binding.root) {

            fun bindView(place: Place) {
                with (binding) {
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
        ): TravelBuddyListAdapter.ItemViewHolder {
            val binding = Design2RecyclerviewItemTravelBuddyBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemViewHolder(binding)
        }

        override fun getItemCount() = travelBuddyList.size

        override fun onBindViewHolder(
            viewHolder: TravelBuddyListAdapter.ItemViewHolder,
            position: Int
        ) {
            viewHolder.bindView(travelBuddyList[position], position)
        }

        inner class ItemViewHolder(
            private val binding: Design2RecyclerviewItemTravelBuddyBinding
        ) : RecyclerView.ViewHolder(binding.root) {

            fun bindView(travelBuddy: TravelBuddy, position: Int) {
                with (binding) {
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
