package com.peopleinteractive.data.di

import com.peopleinteractive.data.repository.UserRepositoryImpl
import com.peopleinteractive.domain.repository.IUserRepository
import org.koin.dsl.module

fun repositoryModule() = module {
    factory<IUserRepository> { UserRepositoryImpl(get(), get(), get(), get(), get()) }

}