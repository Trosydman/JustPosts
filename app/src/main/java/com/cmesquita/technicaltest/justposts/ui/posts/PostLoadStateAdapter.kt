package com.cmesquita.technicaltest.justposts.ui.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.cmesquita.technicaltest.justposts.databinding.ItemPostsLoadStateBinding

class PostLoadStateAdapter(private val postLoadStateListener: PostLoadStateListener) :
    LoadStateAdapter<PostLoadStateViewHolder>() {

    interface PostLoadStateListener {
        fun onRetryClicked()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): PostLoadStateViewHolder {
        return PostLoadStateViewHolder(
            ItemPostsLoadStateBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            postLoadStateListener
        )
    }

    override fun onBindViewHolder(holder: PostLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }
}
