package com.cgkim.jobplanet.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cgkim.jobplanet.R
import com.cgkim.jobplanet.databinding.CellHorizontalThemeBinding
import com.cgkim.jobplanet.model.ThemeItem

// CellType이 CELL_TYPE_HORIZONTAL_TYPE일 경우 해당 Adapter 호출
class HorizontalTypeAdapter : RecyclerView.Adapter<HorizontalTypeAdapter.ViewHolder>() {

    var itemList = listOf<ThemeItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataBindingUtil.inflate<CellHorizontalThemeBinding>(
            LayoutInflater.from(parent.context),
            R.layout.cell_horizontal_theme,
            parent,
            false
        ).let {
            ViewHolder(it)
        }


    override fun getItemCount() = itemList.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(itemList[position])


    inner class ViewHolder(private val binding: CellHorizontalThemeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ThemeItem) {
            binding.apply {
                themeItem = item
                executePendingBindings()
            }
        }
    }
}