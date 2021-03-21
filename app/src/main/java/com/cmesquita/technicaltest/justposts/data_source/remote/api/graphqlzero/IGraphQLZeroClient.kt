package com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero

import com.cmesquita.technicaltest.justposts.PostsQuery

interface IGraphQLZeroClient {

    suspend fun getPosts(page: Int, limit: Int): PostsQuery.Posts
}
