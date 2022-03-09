package com.example.assignmentapnamart.app

import android.app.Application
import com.example.flobizhackathon.di.appModule
import com.example.flobizhackathon.di.repositoryModule
import com.example.flobizhackathon.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    appModule,
                    viewModule,
                    repositoryModule
                )
            )
        }
    }
}