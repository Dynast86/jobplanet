package com.cgkim.jobplanet.extension

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.Spannable
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.view.View
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cgkim.jobplanet.R
import com.cgkim.jobplanet.data.ItemsModel
import com.cgkim.jobplanet.model.ThemeItem
import com.cgkim.jobplanet.ui.adapter.HorizontalTypeAdapter
import com.cgkim.jobplanet.ui.adapter.MyListAdapter
import java.text.NumberFormat
import java.util.*


// 데이터 바인딩

// 검색 리스너
@BindingAdapter("onQueryTextListener")
fun setOnQueryTextListener(view: SearchView, searchByKeyWord: (String) -> Unit) {
    view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextChange(newText: String?): Boolean {
            return false
        }

        override fun onQueryTextSubmit(query: String?): Boolean {
            query?.let { keyWord ->
                searchByKeyWord(keyWord)
            }
            view.clearFocus()
            return false
        }
    })
}


// 이미지 로딩
@BindingAdapter(value = ["imageUrl", "placeHolder"], requireAll = false)
fun setImageUrl(imageView: ImageView, url: String?, placeholder: Drawable?) {
    if (url == null) {
        imageView.setImageDrawable(placeholder)
    } else {
        // 이미지 로딩 실패시 기본 이미지로
        val context = imageView.context
        Glide.with(context).load(url)
            .error(R.drawable.ic_baseline_error_24)
            .into(imageView)
    }
}

// RecyclerView adapter
@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, baseAdapter: RecyclerView.Adapter<*>) {
    view.adapter = baseAdapter
    if (view.id != R.id.horizontalRecyclerView) {
        val dividerItemDecoration = DividerItemDecoration(view.context, RecyclerView.VERTICAL)
        dividerItemDecoration.setDrawable(view.context.resources.getDrawable(R.drawable.divider))
        view.addItemDecoration(dividerItemDecoration)
    }
}

// MainList RecyclerView Items
@BindingAdapter("items")
fun setItems(view: RecyclerView, items: List<*>?) {
    if (view.id == R.id.horizontalRecyclerView) {
        view.adapter = HorizontalTypeAdapter().apply {
            itemList = if (items == null) {
                emptyList()
            } else {
                items as List<ThemeItem>
            }
            notifyDataSetChanged()
        }
    } else {
        view.adapter = MyListAdapter().apply {
            itemList = if (items == null) {
                emptyList()
            } else {
                items as List<ItemsModel>
            }
            notifyDataSetChanged()
        }
    }
}


// 평균연봉 텍스트
@BindingAdapter("salary_text")
fun setText(view: TextView, text: Int?) {
    if (text == 0) {
        view.visibility = View.GONE
    } else {
        view.visibility = View.VISIBLE
    }
    val currency = NumberFormat.getInstance(Locale.KOREA).format(text)
    val context = view.context
    view.text = context.getString(R.string.salary_avg, currency)

    val currencyStart = 5

    val span: Spannable = view.text as Spannable
    span.setSpan(ForegroundColorSpan(Color.GREEN), 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    span.setSpan(RelativeSizeSpan(1.5f), currencyStart, currencyStart + currency.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    span.setSpan(StyleSpan(Typeface.BOLD), currencyStart, currencyStart + currency.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
}