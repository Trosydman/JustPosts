package com.cmesquita.technicaltest.justposts.ui.post_details

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.databinding.FragmentPostDetailsBinding
import com.cmesquita.technicaltest.justposts.utils.extension.themeColor
import com.google.android.material.transition.MaterialContainerTransform
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailsFragment : Fragment(R.layout.fragment_post_details) {

    private val viewModel by viewModels<PostDetailsViewModel>()

    private val binding: FragmentPostDetailsBinding
        get() = _binding!!
    private var _binding: FragmentPostDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.main_navHostFragment
            duration = resources.getInteger(R.integer.justposts_motion_duration_large).toLong()
            scrimColor = ContextCompat.getColor(requireContext(), R.color.transparent)
            setAllContainerColors(requireContext().themeColor(R.attr.colorSurface))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentPostDetailsBinding.bind(view).apply {
            lifecycleOwner = viewLifecycleOwner
            post = viewModel.post
        }

        binding.navigationIcon.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
