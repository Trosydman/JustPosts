package com.cmesquita.technicaltest.justposts.ui.posts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.databinding.FragmentPostsBinding
import com.cmesquita.technicaltest.justposts.ui.post_details.PostDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsFragment : Fragment(R.layout.fragment_posts) {

    private val viewModel by viewModels<PostDetailsViewModel>()

    private val binding: FragmentPostsBinding
        get() = _binding!!
    private var _binding: FragmentPostsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
