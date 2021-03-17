package com.cmesquita.technicaltest.justposts.ui.posts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.databinding.FragmentPostsBinding
import com.cmesquita.technicaltest.justposts.ui.model.Post
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsFragment : Fragment(R.layout.fragment_posts), PostPagingAdapter.PostAdapterListener,
    PostLoadStateAdapter.PostLoadStateListener {

    private val viewModel by viewModels<PostsViewModel>()

    private val binding: FragmentPostsBinding
        get() = _binding!!
    private var _binding: FragmentPostsBinding? = null

    private val pagingAdapter = PostPagingAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPostsBinding.bind(view).apply {
            lifecycleOwner = viewLifecycleOwner
            postsList.adapter = pagingAdapter.withLoadStateHeaderAndFooter(
                header = PostLoadStateAdapter(this@PostsFragment),
                footer = PostLoadStateAdapter(this@PostsFragment)
            )
        }

        viewModel.posts.observe(viewLifecycleOwner) {
            pagingAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    override fun onPostItemClicked(post: Post) {
        // TODO Navigate to details screen
    }

    override fun onRetryClicked() {
        pagingAdapter.retry()
    }
}
