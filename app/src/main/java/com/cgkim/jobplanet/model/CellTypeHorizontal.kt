package com.cgkim.jobplanet.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CellTypeHorizontal(
    var count: Int,
    var theme: MutableList<ThemeItem>
) : Parcelable

@Parcelize
data class ThemeItem(
    var color: String,
    var cover_image: String,
    var id: Int,
    var title: String,
) : Parcelable