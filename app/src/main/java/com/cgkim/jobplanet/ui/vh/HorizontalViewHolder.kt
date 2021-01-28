package com.cgkim.jobplanet.ui.vh

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cgkim.jobplanet.data.ItemsModel
import com.cgkim.jobplanet.databinding.ItemHorizontalThemeBinding
import com.cgkim.jobplanet.model.CellTypeHorizontal
import com.cgkim.jobplanet.ui.adapter.HorizontalTypeAdapter

class HorizontalViewHolder(private val binding: ItemHorizontalThemeBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): HorizontalViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemHorizontalThemeBinding.inflate(layoutInflater, parent, false)

            return HorizontalViewHolder(binding)
        }
    }

    fun bind(item: ItemsModel) {
        binding.apply {
            horizontalAdapter = HorizontalTypeAdapter()
            horizontal = item.cell_object as CellTypeHorizontal
            executePendingBindings()
        }
    }
}