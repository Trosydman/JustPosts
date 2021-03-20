package com.cmesquita.technicaltest.justposts.di

import com.apollographql.apollo.ApolloClient
import com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.GraphQLZeroClient
import com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.IGraphQLZeroClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ClientModule {

    @Singleton
    @Provides
    fun provideApolloClient(): ApolloClient = ApolloClient.builder()
        .serverUrl(GraphQLZeroClient.BASE_URL)
        .build()

    @Singleton
    @Provides
    fun provideGraphQLZeroClient(apolloClient: ApolloClient): IGraphQLZeroClient =
        GraphQLZeroClient(apolloClient)
}
