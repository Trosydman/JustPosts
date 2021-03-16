package com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.mapper

import com.cmesquita.technicaltest.justposts.PostsQuery
import com.cmesquita.technicaltest.justposts.ui.model.Post
import com.cmesquita.technicaltest.justposts.utils.DomainMapper
import javax.inject.Inject

class PostsResponseDTOMapper @Inject constructor(
    private val dataDTOMapper: Data1DTOMapper
) : DomainMapper<List<Post>?, PostsQuery.Posts> {

    override fun mapToDomainModel(dtoModel: PostsQuery.Posts): List<Post>? {
        return if (dtoModel.data != null) {
            dataDTOMapper.mapToDomainModelList(dtoModel.data).filterNotNull()
        } else {
            null
        }
    }

    override fun mapToDomainModelList(dtoModelList: List<PostsQuery.Posts>): List<List<Post>?> {
        return dtoModelList.map { mapToDomainModel(it) }
    }
}