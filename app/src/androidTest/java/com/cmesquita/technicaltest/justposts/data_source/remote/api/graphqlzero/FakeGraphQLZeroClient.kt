package com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero

import com.cmesquita.technicaltest.justposts.PostsQuery

class FakeGraphQLZeroClient : IGraphQLZeroClient {

    private val mockDataList = MockClientResponse.fakeDefaultData1List

    override suspend fun getPosts(page: Int, limit: Int): PostsQuery.Posts =
        try {
            PostsQuery.Posts(data = mockDataList.chunked(limit)[page - 1])
        } catch (ioobe: IndexOutOfBoundsException) {
            PostsQuery.Posts(data = emptyList<PostsQuery.Data1>())
        }
}
