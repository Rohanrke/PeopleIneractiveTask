package com.peopleinteractive.core.di

import androidx.lifecycle.ProcessLifecycleOwner
import org.koin.dsl.module

val mainModule = module {
   // single { ProcessLifecycleOwner.get().lifecycle.coroutineScope }
}
