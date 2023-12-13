package com.kproject.cleidesigns.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.kproject.cleidesigns.databinding.RecyclerviewItemDesignBinding

class DesignAdapter(
    private val designList: List<DesignXML>,
    private val onItemClickListener: ((design: DesignXML, view: View, position: Int) -> Unit)
) : RecyclerView.Adapter<DesignAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): ImageViewHolder {
        val binding = RecyclerviewItemDesignBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun getItemCount() = designList.size

    override fun onBindViewHolder(viewHolder: ImageViewHolder, position: Int) {
        viewHolder.bindView(designList[position], position)
    }

    inner class ImageViewHolder(
        private val binding: RecyclerviewItemDesignBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(design: DesignXML, position: Int) {
            with (binding) {
                ivImage.load(design.image) {
                    scale(Scale.FILL)
                }
                tvDesignTitle.text = design.title
            }

            itemView.setOnClickListener { view ->
                onItemClickListener(design, view, position)
            }
        }
    }
}