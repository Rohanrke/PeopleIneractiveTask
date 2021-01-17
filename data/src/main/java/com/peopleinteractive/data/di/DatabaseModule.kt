package com.peopleinteractive.data.di

import android.app.Application
import androidx.room.Room
import com.peopleinteractive.data.local.AppDatabase
import com.peopleinteractive.data.local.dao.UserDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

fun databaseModule() = module {
    single {  provideRDatabase(get())}
    single {  providesDao(get())}


}


fun provideRDatabase(
    application: Application,
): AppDatabase {
    return  Room.databaseBuilder(application, AppDatabase::class.java, "app-db").build();
}

fun providesDao(database: AppDatabase): UserDao{
    return database.userDao()
}

