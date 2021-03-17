package com.cmesquita.technicaltest.justposts.ui.posts

import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.cmesquita.technicaltest.justposts.databinding.ItemPostsLoadStateBinding

class PostLoadStateViewHolder(
    private val binding: ItemPostsLoadStateBinding,
    postLoadStateListener: PostLoadStateAdapter.PostLoadStateListener
) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.listener = postLoadStateListener
    }

    fun bind(loadState: LoadState) {
        with(binding) {
            loadingBar.isVisible = loadState is LoadState.Loading
            errorGroup.isVisible = loadState !is LoadState.Loading
        }
    }
}
