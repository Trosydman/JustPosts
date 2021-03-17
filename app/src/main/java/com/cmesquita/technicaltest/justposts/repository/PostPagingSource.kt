package com.cmesquita.technicaltest.justposts.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.apollographql.apollo.exception.ApolloException
import com.cmesquita.technicaltest.justposts.data_source.remote.GraphQLZeroRemoteDataSource
import com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.mapper.PostsResponseDTOMapper
import com.cmesquita.technicaltest.justposts.ui.model.Post
import kotlinx.coroutines.flow.first

class PostPagingSource(
    private val graphQLZeroRemoteDataSource: GraphQLZeroRemoteDataSource,
    private val postsResponseDTOMapper: PostsResponseDTOMapper
) : PagingSource<Int, Post>() {

    companion object {
        const val FIRST_PAGE_INDEX = 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        val position = params.key ?: FIRST_PAGE_INDEX

        return try {
            val postsResponseDTO = graphQLZeroRemoteDataSource.getPosts(position, params.loadSize)
                .first()
            val posts = postsResponseDTOMapper.mapToDomainModel(postsResponseDTO)
                ?: throw Exception("Posts are null")

            LoadResult.Page(
                data = posts.filterNotNull(),
                prevKey = if (position == FIRST_PAGE_INDEX) null else position - 1,
                nextKey = if (posts.isEmpty()) null else position + 1
            )
        } catch (exception: ApolloException) {
            LoadResult.Error(exception)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        return state.anchorPosition
    }
}
