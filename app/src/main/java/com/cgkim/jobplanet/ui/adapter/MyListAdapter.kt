package com.cgkim.jobplanet.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cgkim.jobplanet.R
import com.cgkim.jobplanet.data.ItemsModel
import com.cgkim.jobplanet.ui.vh.CompanyViewHolder
import com.cgkim.jobplanet.ui.vh.HorizontalViewHolder
import com.cgkim.jobplanet.ui.vh.ReviewViewHolder

class MyListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var itemList = listOf<ItemsModel>()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = itemList[position]

        when (item.cell_type) {
            "CELL_TYPE_HORIZONTAL_THEME" -> {
                (holder as HorizontalViewHolder).bind(item)
            }
            "CELL_TYPE_REVIEW" -> {
                (holder as ReviewViewHolder).bind(item)
            }
            else -> {
                (holder as CompanyViewHolder).bind(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_horizontal_theme -> {
                HorizontalViewHolder.from(parent)
            }
            R.layout.item_review -> {
                ReviewViewHolder.from(parent)
            }
            else -> {
                CompanyViewHolder.from(parent)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item: ItemsModel = itemList[position]

        return when (item.cell_type) {
            "CELL_TYPE_HORIZONTAL_THEME" -> {
                R.layout.item_horizontal_theme
            }
            "CELL_TYPE_REVIEW" -> {
                R.layout.item_review
            }
            else -> {
                R.layout.item_company
            }
        }
    }

    override fun getItemCount() = itemList.size
}