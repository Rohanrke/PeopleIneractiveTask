package com.peopleinteractive.task

import android.app.Application
import com.peopleinteractive.core.di.mainModule
import com.peopleinteractive.core.di.retrofitModule
import com.peopleinteractive.core.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin

class App: Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    fun initKoin() {
        startKoin() {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    mainModule,
                    useCaseModule,
                    retrofitModule()
                )
            )
        }
    }
}