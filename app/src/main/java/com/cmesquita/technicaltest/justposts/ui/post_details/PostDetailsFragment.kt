package com.cmesquita.technicaltest.justposts.ui.post_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.ui.theme.JustPostsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailsFragment : Fragment(R.layout.fragment_post_details) {

    private val viewModel by viewModels<PostDetailsViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                JustPostsTheme {
                    PostDetails(
                        post = viewModel.post!!,
                        onCloseButtonClicked = {
                            findNavController().popBackStack()
                        }
                    )
                }
            }
        }
    }
}
