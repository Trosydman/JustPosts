package com.cmesquita.technicaltest.justposts.di

import com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.FakeGraphQLZeroClient
import com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.IGraphQLZeroClient
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [ClientModule::class]
)
object ClientTestModule {

    @Singleton
    @Provides
    fun provideGraphQLZeroClient(): IGraphQLZeroClient = FakeGraphQLZeroClient()
}
