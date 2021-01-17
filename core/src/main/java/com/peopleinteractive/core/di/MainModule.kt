package com.peopleinteractive.core.di

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


fun mainModule() = module {
    single { androidApplication() }
}