package com.cgkim.jobplanet

import android.app.Application
import com.cgkim.jobplanet.data.ApiService
import com.cgkim.jobplanet.data.DataDeserializer
import com.cgkim.jobplanet.data.DataModel
import com.cgkim.jobplanet.repo.Repository
import com.cgkim.jobplanet.repo.RepositoryImpl
import com.cgkim.jobplanet.ui.detail.DetailViewModel
import com.cgkim.jobplanet.ui.ListViewModel
import com.cgkim.jobplanet.ui.detail.DetailInfoViewModel
import com.cgkim.jobplanet.ui.detail.DetailReviewViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JobPlanetApplication : Application() {

    companion object {
        const val BASE_URL = "https://jpassets.jobplanet.co.kr"
    }

    private val gson: Gson by lazy {
        GsonBuilder()
            .registerTypeAdapter(DataModel::class.java, DataDeserializer())
            .create()
    }
    private var myModule = module {
        single {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }

        single {
            get<Retrofit>().create(ApiService::class.java)
        }
        single<Repository> { RepositoryImpl(get()) }
        viewModel { ListViewModel(get()) }
        viewModel { DetailViewModel() }
        viewModel { DetailInfoViewModel() }
        viewModel { DetailReviewViewModel() }
    }

    override fun onCreate() {
        super.onCreate()

        // 의존성 주입
        // 해당 모듈은 상단(myModule)에서 생성
        startKoin {
            androidContext(this@JobPlanetApplication)
            modules(myModule)
        }
    }
}