package com.cmesquita.technicaltest.justposts.data_source

import kotlinx.coroutines.flow.Flow

interface DataSource<DTO> {
    fun getPosts(page: Int, limit: Int): Flow<DTO>
}
