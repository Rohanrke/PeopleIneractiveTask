package com.peopleinteractive.data.di

import com.google.gson.GsonBuilder
import com.peopleinteractive.data.remote.service.UserService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

fun retrofitModule() = module {
    single { provideLoggingInterceptor() }
    single { provideOkHttpClient(get()) }
    single {
        provideRetrofit(
            "https://randomuser.me",
            get(),
            GsonConverterFactory.create(GsonBuilder().create())
        )
    }
    single { provideUserService(get()) }
}

/*
 * The method returns the Retrofit object
 * */
fun provideRetrofit(
    baseUrl: String,
    okHttpClient: OkHttpClient.Builder,
    factory: GsonConverterFactory
): Retrofit {
    Timber.v("Base Url \$baseUrl")
    return Retrofit.Builder().client(okHttpClient.build())
        .addConverterFactory(factory)
        .baseUrl(baseUrl)
        .build()
}


fun provideLoggingInterceptor() =
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient.Builder {
    val httpClient = OkHttpClient.Builder()
    httpClient.addInterceptor(httpLoggingInterceptor)
    Timber.v("")
    return httpClient
}

fun provideUserService(retrofit: Retrofit): UserService = retrofit.create(UserService::class.java)
