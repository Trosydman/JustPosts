package com.cmesquita.technicaltest.justposts.di

import com.cmesquita.technicaltest.justposts.data_source.remote.GraphQLZeroRemoteDataSource
import com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.mapper.Data1DTOMapper
import com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.mapper.PostsResponseDTOMapper
import com.cmesquita.technicaltest.justposts.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideData1DTOMapper() = Data1DTOMapper()

    @Singleton
    @Provides
    fun providePostsResponseDTOMapper(data1DTOMapper: Data1DTOMapper) =
        PostsResponseDTOMapper(data1DTOMapper)

    @Singleton
    @Provides
    fun providePostRepository(
        graphQLZeroRemoteDataSource: GraphQLZeroRemoteDataSource,
        postsResponseDTOMapper: PostsResponseDTOMapper
    ) = PostRepository(graphQLZeroRemoteDataSource, postsResponseDTOMapper)
}