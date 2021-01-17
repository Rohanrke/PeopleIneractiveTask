package com.peopleinteractive.data.di

import com.peopleinteractive.data.mapper.RemoteToEntityMapper
import com.peopleinteractive.data.mapper.UserDomainMapper
import com.peopleinteractive.data.mapper.UserEntityMapper
import org.koin.dsl.module


fun mapperModule() = module {
    factory { UserEntityMapper() }
    factory { RemoteToEntityMapper() }
    factory { UserDomainMapper() }
}