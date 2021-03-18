package com.cmesquita.technicaltest.justposts.ui.posts

import android.os.Bundle
import android.view.View
import androidx.core.view.doOnPreDraw
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.databinding.FragmentPostsBinding
import com.cmesquita.technicaltest.justposts.ui.model.Post
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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
    private val headerLoadStateAdapter = PostLoadStateAdapter(this)
    private val footerLoadStateAdapter = PostLoadStateAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fix reenter animation
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }

        _binding = FragmentPostsBinding.bind(view).apply {
            lifecycleOwner = viewLifecycleOwner
            postsList.adapter = pagingAdapter.withLoadStateHeaderAndFooter(
                header = headerLoadStateAdapter,
                footer = footerLoadStateAdapter
            )
        }

        connectViews()

        viewModel.connectionLiveData.observe(viewLifecycleOwner) { isNetworkAvailable ->
            if (isNetworkAvailable) {
                retryAdapter()
            }

            binding.noConnectionBanner.isVisible = !isNetworkAvailable
        }

        viewModel.posts.observe(viewLifecycleOwner) {
            pagingAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }

        setupLoadStateListener()
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

    override fun onRetryClicked() {
        retryAdapter()
    }

    private fun retryAdapter() {
        pagingAdapter.retry()
    }

    private fun connectViews() {
        with(binding) {
            emptyListInfo.retryButton.setOnClickListener {
                retryAdapter()
            }
        }
    }

    private fun setupLoadStateListener() {
        pagingAdapter.addLoadStateListener { loadState ->
            val refreshState = loadState.source.refresh
            val isEmpty = refreshState is LoadState.NotLoading &&
                    loadState.append.endOfPaginationReached && pagingAdapter.itemCount < 1
            val errorState = when {
                loadState.source.append is LoadState.Error ->
                    loadState.source.append as LoadState.Error

                loadState.source.prepend is LoadState.Error ->
                    loadState.source.prepend as LoadState.Error

                loadState.source.refresh is LoadState.Error ->
                    loadState.source.refresh as LoadState.Error
                else -> null
            }

            showError(errorState?.error)

            binding.apply {
                loadingBar.isVisible = refreshState is LoadState.Loading
                postsList.isVisible = refreshState is LoadState.NotLoading && !isEmpty
                emptyListInfo.root.isVisible = isEmpty
            }
        }
    }

    private fun showError(error: Throwable?) {
        val isNetworkAvailable = viewModel.connectionLiveData.value ?: false

        if (!isNetworkAvailable) {
            binding.noConnectionBanner.isVisible = true
            return
        }

        if (error != null) {
            MaterialAlertDialogBuilder(context ?: return)
                .setTitle(R.string.title_unexpected_error)
                .setMessage(getString(R.string.message_unexpected_error, error.localizedMessage))
                .setPositiveButton(R.string.action_retry) { _, _ ->
                    retryAdapter()
                }
                .setCancelable(false)
                .show()
        }
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
}
