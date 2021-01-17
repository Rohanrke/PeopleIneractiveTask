package com.peopleinteractive.task

import android.app.Application
import com.peopleinteractive.core.di.mainModule
import com.peopleinteractive.data.di.databaseModule
import com.peopleinteractive.data.di.retrofitModule
import com.peopleinteractive.data.di.mapperModule
import com.peopleinteractive.data.di.repositoryModule
import com.peopleinteractive.task.feature.home.di.homeScope
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin

class App : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    fun initKoin() {
        startKoin() {
            androidLogger()
            androidContext(this@App)
            koin.loadModules(
                listOf(repositoryModule(),  databaseModule(), mapperModule(), retrofitModule(), homeScope(), mainModule())
            )
            koin.createRootScope()
        }
    }
}