package com.peopleinteractive.core.di

import com.peopleinteractive.core.utils.SystemUtils
import org.koin.dsl.module

fun mainModule() = module {
    single { SystemUtils(get()) }
}