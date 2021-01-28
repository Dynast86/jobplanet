package com.cgkim.jobplanet.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.cgkim.jobplanet.R
import com.cgkim.jobplanet.databinding.ActivityMainBinding
import com.cgkim.jobplanet.ui.adapter.MyListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val listViewModel: ListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            lifecycleOwner = this@MainActivity
            adapter = MyListAdapter()
            viewModel = listViewModel
        }
    }
}