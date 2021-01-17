package com.peopleinteractive.data.di

import com.google.gson.GsonBuilder
import com.peopleinteractive.data.remote.service.UserService
import com.peopleinteractive.data.repository.UserRepositoryImpl
import com.peopleinteractive.domain.repository.IUserRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

fun repositoryModule() = module {
    factory<IUserRepository> { UserRepositoryImpl(get(), get(), get(), get(), get()) }

}