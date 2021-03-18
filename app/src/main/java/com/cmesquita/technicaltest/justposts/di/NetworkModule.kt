package com.cmesquita.technicaltest.justposts.di

import android.content.Context
import com.cmesquita.technicaltest.justposts.ui.utils.ConnectionLiveData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule {

    @ViewModelScoped
    @Provides
    fun provideConnectionLiveData(@ApplicationContext app: Context) = ConnectionLiveData(app)
}
