package com.cmesquita.technicaltest.justposts.ui.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.cmesquita.technicaltest.justposts.databinding.ItemPostBinding
import com.cmesquita.technicaltest.justposts.ui.model.Post

class PostPagingAdapter(
    private val postAdapterListener: PostAdapterListener
) : PagingDataAdapter<Post, PostViewHolder>(POST_COMPARATOR) {

    interface PostAdapterListener {
        fun onPostItemClicked(view: View, post: Post)
    }

    companion object {
        private val POST_COMPARATOR = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Post, newItem: Post) =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PostViewHolder(binding, postAdapterListener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}
