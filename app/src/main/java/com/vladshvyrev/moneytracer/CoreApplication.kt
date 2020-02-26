package com.vladshvyrev.moneytracer

import android.app.Application
import com.vladshvyrev.moneytracer.Koin.dbModule
import com.vladshvyrev.moneytracer.Koin.repositoryModule
import com.vladshvyrev.moneytracer.Koin.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CoreApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CoreApplication)
            modules(listOf(
                dbModule,
                repositoryModule,
                uiModule
            ))
        }
    }
}