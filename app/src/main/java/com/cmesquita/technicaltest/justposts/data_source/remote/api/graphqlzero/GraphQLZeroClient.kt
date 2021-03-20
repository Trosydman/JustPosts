package com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.cmesquita.technicaltest.justposts.PostsQuery
import com.cmesquita.technicaltest.justposts.PostsQuery.Posts
import com.cmesquita.technicaltest.justposts.type.PageQueryOptions
import com.cmesquita.technicaltest.justposts.type.PaginateOptions
import timber.log.Timber

class GraphQLZeroClient(
    private val apolloClient: ApolloClient
) : IGraphQLZeroClient {

    companion object {
        const val BASE_URL = "https://graphqlzero.almansi.me/api"
    }

    override suspend fun getPosts(page: Int, limit: Int): Posts {
        val pageQueryOptions = PageQueryOptions(
            Input.optional(
                PaginateOptions(
                    Input.optional(page),
                    Input.optional(limit)
                )
            )
        )
        val postsQuery = PostsQuery(Input.optional(pageQueryOptions))
        val response = apolloClient.query(postsQuery).await()

        if (response.hasErrors()) {
            val errorMessagesBuilder = StringBuilder()
            response.errors!!.forEach {
                errorMessagesBuilder.append("${it.message}\n")
            }

            Timber.e(errorMessagesBuilder.toString())
            throw ApolloException(errorMessagesBuilder.toString())
        }

        return response.data?.posts ?: kotlin.run {
            val errorMessage = "Posts are null"

            Timber.e(errorMessage)
            throw ApolloException(errorMessage)
        }
    }
}
