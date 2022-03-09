package com.example.flobizhackathon.di

import com.example.assignmentapnamart.network.ApiClient
import com.example.assignmentapnamart.network.ApiInterface
import com.example.assignmentapnamart.repo.Repo
import com.example.assignmentapnamart.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {
    single { provideRetrofit() }
    single { provideApiInterface(get() as Retrofit) }
}

val viewModule = module {
    viewModel { MainViewModel(get() as Repo) }
}

val repositoryModule = module {
    single { Repo(get() as ApiInterface) }
}

private fun provideRetrofit(): Retrofit {
    return ApiClient.getRetrofit()
}

private fun provideApiInterface(retrofit: Retrofit): ApiInterface {
    return retrofit.create(ApiInterface::class.java)
}
