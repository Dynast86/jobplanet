package com.cgkim.jobplanet.extension

import android.content.Intent
import android.view.View
import com.cgkim.jobplanet.model.CellTypeCompany
import com.cgkim.jobplanet.model.CellTypeReview
import com.cgkim.jobplanet.ui.detail.DetailActivity

class ClickHandler {
    fun onDetailClick(view: View, task: Any) {
        val context = view.context

        val intent = if (task is CellTypeCompany) {
            Intent(context, DetailActivity::class.java).apply {
                putExtra("data", task)
            }
        } else {
            val item = task as CellTypeReview
            Intent(context, DetailActivity::class.java).apply {
                putExtra("data", item)
            }
        }

        context.startActivity(intent)
    }
}