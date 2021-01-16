package com.peopleinteractive.core.di


import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val networkModule = module {
  //  single<RestClient> { ClientManager(androidContext()).peekRestClient() }
}

