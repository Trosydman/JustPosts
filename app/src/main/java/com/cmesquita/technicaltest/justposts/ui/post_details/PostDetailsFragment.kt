package com.cmesquita.technicaltest.justposts.ui.post_details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.databinding.FragmentPostDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailsFragment : Fragment(R.layout.fragment_post_details) {

    private val viewModel by viewModels<PostDetailsViewModel>()

    private val binding: FragmentPostDetailsBinding
        get() = _binding!!
    private var _binding: FragmentPostDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
