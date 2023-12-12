package com.kproject.cleidesigns.feature.design2.xml.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kproject.cleidesigns.feature.design2.databinding.RecyclerviewItemPlaceBinding
import com.kproject.cleidesigns.feature.design2.model.Place

internal class ListOfPlacesAdapter(
    private val listOfPlaces: List<Place>,
    private val onItemClickListener: ((place: Place) -> Unit)
) : RecyclerView.Adapter<ListOfPlacesAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        view: Int
    ): ItemViewHolder {
        val binding = RecyclerviewItemPlaceBinding
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
        private val binding: RecyclerviewItemPlaceBinding
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
