package com.example.ktorsample.appCore

import android.app.Application
import com.example.mortyandsmith.di.networkModule
import com.example.mortyandsmith.di.repositoryModule
import com.example.mortyandsmith.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(repositoryModule)
            modules(networkModule)
            modules(viewModelModule)
        }
    }
}