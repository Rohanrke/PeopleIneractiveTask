package com.peopleinteractive.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * Created by Rohan Singh on 22/09/20.
 */

@Module
@InstallIn(ActivityRetainedComponent::class)
object CoroutineScopeModule {

    @Provides
    fun provideIOCoroutineContext(): CoroutineContext = Dispatchers.IO
}