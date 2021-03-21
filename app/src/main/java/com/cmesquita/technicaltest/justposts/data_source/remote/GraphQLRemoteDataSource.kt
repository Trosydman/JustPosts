package com.cmesquita.technicaltest.justposts.data_source.remote

import com.cmesquita.technicaltest.justposts.PostsQuery.Posts
import com.cmesquita.technicaltest.justposts.data_source.DataSource
import com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.IGraphQLZeroClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GraphQLZeroRemoteDataSource(
    private val graphQLZeroClient: IGraphQLZeroClient,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : DataSource<Posts> {

    override fun getPosts(page: Int, limit: Int): Flow<Posts> = flow {
        val posts = graphQLZeroClient.getPosts(page, limit)
        emit(posts)
    }.flowOn(defaultDispatcher)
}
