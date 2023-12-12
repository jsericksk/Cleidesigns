package com.kproject.cleidesigns.feature.design2.xml.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kproject.cleidesigns.feature.design2.databinding.RecyclerviewItemTravelBuddyBinding
import com.kproject.cleidesigns.feature.design2.model.TravelBuddy

internal class TravelBuddyListAdapter(
    private val travelBuddyList: List<TravelBuddy>,
    private val onItemClickListener: ((travelBuddy: TravelBuddy) -> Unit)
) : RecyclerView.Adapter<TravelBuddyListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        view: Int
    ): ItemViewHolder {
        val binding = RecyclerviewItemTravelBuddyBinding
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
        private val binding: RecyclerviewItemTravelBuddyBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(travelBuddy: TravelBuddy, position: Int) {
            with(binding) {
                if ((position % 2) == 0) {
                    cvMainCardView.setCardBackgroundColor(Color.parseColor("#00664F"))
                } else {
                    cvMainCardView.setCardBackgroundColor(Color.parseColor("#9BA1FF"))
                }
                tvName.text = travelBuddy.name
                tvAge.text = travelBuddy.age.toString()
                tvStatus.text = if (travelBuddy.isFriend) "Friend" else "Unknown"
                ivPersonImage.load(travelBuddy.personImage)
            }

            itemView.setOnClickListener {
                onItemClickListener(travelBuddy)
            }
        }
    }
}