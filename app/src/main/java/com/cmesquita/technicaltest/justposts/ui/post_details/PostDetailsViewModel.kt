package com.cmesquita.technicaltest.justposts.ui.post_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.cmesquita.technicaltest.justposts.ui.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    state: SavedStateHandle
) : ViewModel() {

    val post = state.get<Post>("post")
}
