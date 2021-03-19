package com.cmesquita.technicaltest.justposts.di

import android.content.Context
import com.cmesquita.technicaltest.justposts.ui.utils.ConnectionLiveData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideConnectionLiveData(@ApplicationContext app: Context) = ConnectionLiveData(app)
}
