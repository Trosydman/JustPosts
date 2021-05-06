package com.cmesquita.technicaltest.justposts.ui.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.Column
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.ui.model.Post
import com.cmesquita.technicaltest.justposts.ui.theme.JustPostsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsFragment : Fragment() {

    private val viewModel by viewModels<PostsViewModel>()

    @VisibleForTesting(otherwise = PRIVATE)
    var enableTransitions = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val connectionState = viewModel.connectionLiveData.observeAsState()

                JustPostsTheme {
                    Scaffold(
                        floatingActionButtonPosition = FabPosition.End,
                        floatingActionButton = {
                            FloatingActionButton(
                                onClick = { toggleTheme() }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_day_night),
                                    contentDescription = "Switch between Light and Dark theme"
                                )
                            }
                        }
                    ) {
                        Column {
                            if (connectionState.value == false) {
                                NoConnectionBanner()
                            }

                            PostList(
                                posts = viewModel.posts,
                                connectionState = connectionState,
                                onPostItemClicked = { navigateToPostDetails(it) }
                            )
                        }
                    }
                }
            }
        }
    }

    private fun navigateToPostDetails(post: Post) {
        findNavController().navigate(
            PostsFragmentDirections.toPostDetailsFragment(post)
        )
    }

    private fun toggleTheme() {
        if (AppCompatDelegate.getDefaultNightMode() != AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}
