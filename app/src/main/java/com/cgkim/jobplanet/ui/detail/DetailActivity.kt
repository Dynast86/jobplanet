package com.cgkim.jobplanet.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.cgkim.jobplanet.R
import com.cgkim.jobplanet.databinding.ActivityDetailBinding
import com.cgkim.jobplanet.model.CellTypeCompany
import com.cgkim.jobplanet.model.CellTypeReview
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private val detailViewModel: DetailViewModel by viewModel()
    private val detailInfoViewModel: DetailInfoViewModel by viewModel()
    private val detailReviewViewModel: DetailReviewViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail).apply {
            lifecycleOwner = this@DetailActivity
            viewModel = detailViewModel
            infoViewModel = detailInfoViewModel
            reviewViewModel = detailReviewViewModel
        }

        initData()
    }

    private fun initData() {
        val data = intent.extras?.get("data")

        val type: String?

        if (data is CellTypeCompany) {
            title = resources.getString(R.string.info_title)
            detailViewModel.title.value = data.name
            detailViewModel.rateAvg.value = data.rate_total_avg
            detailViewModel.industryName.value = data.industry_name
            detailViewModel.imageUrl.value = data.logo_path
            detailViewModel.reviewSummary.value = data.review_summary

            type = data.type
            detailInfoViewModel.data.value = data
        } else {
            data as CellTypeReview
            title = resources.getString(R.string.review_title)
            detailViewModel.title.value = data.name
            detailViewModel.rateAvg.value = data.rate_total_avg
            detailViewModel.industryName.value = data.industry_name
            detailViewModel.imageUrl.value = data.logo_path
            detailViewModel.occupationName.value = data.occupation_name
            detailViewModel.reviewSummary.value = data.review_summary

            type = data.type
            detailReviewViewModel.data.value = data
        }
        detailViewModel.type.value = type
    }
}