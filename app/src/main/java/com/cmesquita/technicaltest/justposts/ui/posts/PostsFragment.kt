package com.cmesquita.technicaltest.justposts.ui.posts

import android.os.Bundle
import android.view.View
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.databinding.FragmentPostsBinding
import com.cmesquita.technicaltest.justposts.ui.model.Post
import com.google.android.material.transition.MaterialElevationScale
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

        // Fix reenter animation
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }

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

    override fun onPostItemClicked(view: View, post: Post) {
        val extras = setupNavigatorExtras(view)
        val directions = PostsFragmentDirections.toPostDetailsFragment(post)

        findNavController().navigate(directions, extras)
    }

    private fun setupNavigatorExtras(view: View): FragmentNavigator.Extras {
        exitTransition = MaterialElevationScale(false).apply {
            duration = resources.getInteger(R.integer.justposts_motion_duration_large).toLong()
        }
        reenterTransition = MaterialElevationScale(true).apply {
            duration = resources.getInteger(R.integer.justposts_motion_duration_large).toLong()
        }

        val emailCardDetailTransitionName = getString(R.string.post_card_detail_transition_name)

        return FragmentNavigatorExtras(view to emailCardDetailTransitionName)
    }

    override fun onRetryClicked() {
        pagingAdapter.retry()
    }
}
