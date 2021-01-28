package com.cgkim.jobplanet.ui.vh

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cgkim.jobplanet.data.ItemsModel
import com.cgkim.jobplanet.databinding.ItemReviewBinding
import com.cgkim.jobplanet.extension.ClickHandler
import com.cgkim.jobplanet.model.CellTypeReview

class ReviewViewHolder(private val binding: ItemReviewBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): ReviewViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemReviewBinding.inflate(layoutInflater, parent, false)

            return ReviewViewHolder(binding)
        }
    }

    fun bind(item: ItemsModel) {
        binding.apply {
            review = item.cell_object as CellTypeReview
            executePendingBindings()
            handler = ClickHandler()
        }
    }
}