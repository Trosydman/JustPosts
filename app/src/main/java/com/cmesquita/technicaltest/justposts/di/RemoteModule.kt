package com.cmesquita.technicaltest.justposts.di

import com.cmesquita.technicaltest.justposts.data_source.remote.GraphQLZeroRemoteDataSource
import com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.IGraphQLZeroClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun provideGraphQLZeroRemoteDataSource(
        graphQLZeroClient: IGraphQLZeroClient
    ): GraphQLZeroRemoteDataSource = GraphQLZeroRemoteDataSource(graphQLZeroClient)
}
