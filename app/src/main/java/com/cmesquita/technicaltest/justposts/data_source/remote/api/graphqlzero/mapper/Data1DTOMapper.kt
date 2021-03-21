package com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.mapper

import com.cmesquita.technicaltest.justposts.PostsQuery
import com.cmesquita.technicaltest.justposts.ui.model.Post
import com.cmesquita.technicaltest.justposts.ui.model.User
import com.cmesquita.technicaltest.justposts.utils.DomainMapper

class Data1DTOMapper : DomainMapper<Post?, PostsQuery.Data1?> {

    override fun mapToDomainModel(dtoModel: PostsQuery.Data1?): Post? {

        return dtoModel?.let {
            with(dtoModel.fragments.post) {
                if (title.isNullOrBlank() && body.isNullOrBlank()) {
                    null
                } else {
                    Post(
                        id?.toLong(),
                        title,
                        body,
                        User(
                            user?.name,
                            user?.username
                        )
                    )
                }
            }
        } ?: run { null }
    }

    override fun mapToDomainModelList(dtoModelList: List<PostsQuery.Data1?>): List<Post?> {
        return dtoModelList.mapNotNull { mapToDomainModel(it) }
    }
}