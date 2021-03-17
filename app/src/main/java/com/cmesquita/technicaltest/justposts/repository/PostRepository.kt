package com.cmesquita.technicaltest.justposts.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.cmesquita.technicaltest.justposts.data_source.remote.GraphQLZeroRemoteDataSource
import com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.mapper.PostsResponseDTOMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class PostRepository(
    private val graphQLZeroRemoteDataSource: GraphQLZeroRemoteDataSource,
    private val postsResponseDTOMapper: PostsResponseDTOMapper,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    fun getPosts() =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PostPagingSource(graphQLZeroRemoteDataSource, postsResponseDTOMapper)
            }
        ).flow
            .flowOn(defaultDispatcher)
}
