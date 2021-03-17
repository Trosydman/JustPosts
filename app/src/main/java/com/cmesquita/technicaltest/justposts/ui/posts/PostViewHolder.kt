package com.cmesquita.technicaltest.justposts.ui.posts

import androidx.recyclerview.widget.RecyclerView
import com.cmesquita.technicaltest.justposts.databinding.ItemPostBinding
import com.cmesquita.technicaltest.justposts.ui.model.Post

class PostViewHolder(
    private val binding: ItemPostBinding,
    private val postAdapterListener: PostPagingAdapter.PostAdapterListener
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.listener = postAdapterListener
    }

    fun bind(post: Post) {
        binding.post = post
    }
}
