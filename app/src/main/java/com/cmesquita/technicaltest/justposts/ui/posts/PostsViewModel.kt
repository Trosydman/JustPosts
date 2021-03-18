package com.cmesquita.technicaltest.justposts.ui.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.filter
import com.cmesquita.technicaltest.justposts.repository.PostRepository
import com.cmesquita.technicaltest.justposts.ui.utils.ConnectionLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    postRepository: PostRepository,
    val connectionLiveData: ConnectionLiveData
) : ViewModel() {

    companion object {
        const val DEFAULT_PAGE_SIZE = 10
        const val DEFAULT_MAX_SIZE = 40
    }

    val posts = postRepository.getPosts()
        .onEach { pagingData ->
            pagingData.filter { it.title != null && it.body != null }
        }
        .cachedIn(viewModelScope)
        .asLiveData()
}
