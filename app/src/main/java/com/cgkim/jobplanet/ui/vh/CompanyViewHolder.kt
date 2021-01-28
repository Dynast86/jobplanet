package com.cgkim.jobplanet.ui.vh

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cgkim.jobplanet.data.ItemsModel
import com.cgkim.jobplanet.databinding.ItemCompanyBinding
import com.cgkim.jobplanet.extension.ClickHandler
import com.cgkim.jobplanet.model.CellTypeCompany

class CompanyViewHolder(private val binding: ItemCompanyBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): CompanyViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemCompanyBinding.inflate(layoutInflater, parent, false)

            return CompanyViewHolder(binding)
        }
    }

    fun bind(item: ItemsModel) {
        binding.apply {
            company = item.cell_object as CellTypeCompany
            executePendingBindings()
            handler = ClickHandler()
        }
    }
}