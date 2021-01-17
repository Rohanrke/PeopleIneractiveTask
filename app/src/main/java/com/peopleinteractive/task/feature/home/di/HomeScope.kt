package com.peopleinteractive.task.feature.home.di

import com.peopleinteractive.task.feature.home.HomeViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun homeScope() = module {
    viewModel { HomeViewModel(Dispatchers.IO, get()) }
}
