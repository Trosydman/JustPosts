package com.cmesquita.technicaltest.justposts.ui.posts

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.ui.custom.ErrorAlertDialog
import com.cmesquita.technicaltest.justposts.ui.custom.LoadingView
import com.cmesquita.technicaltest.justposts.ui.model.MockUiModels
import com.cmesquita.technicaltest.justposts.ui.model.Post
import com.cmesquita.technicaltest.justposts.ui.theme.JustPostsTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Composable
fun PostList(
    posts: Flow<PagingData<Post>>,
    // TODO Remove below list whenever the list above works for the Preview
    postsTest: List<Post>? = null
) {
    val lazyPostItems: LazyPagingItems<Post> = posts.collectAsLazyPagingItems()

    LazyColumn {
        if (postsTest != null) {
            items(postsTest) { post ->
                PostItem(
                    post = post,
                    onItemClicked = {
                        // TODO
                    }
                )
            }
        } else {
            items(lazyPostItems) { post ->
                post?.let {
                    PostItem(
                        post = it,
                        onItemClicked = {
                            // TODO
                        }
                    )
                }
            }
        }

        with(lazyPostItems) {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { LoadingView() }
                }

                loadState.append is LoadState.Loading -> {
                    item { LoadingStateItem() }
                }

                loadState.refresh is LoadState.Error || loadState.append is LoadState.Error -> {
                    item {
                        ErrorStateItem(
                            onRetryClicked = {
                                retry()
                            }
                        )
                    }
                }
            }
        }
    }

    if (lazyPostItems.loadState.refresh is LoadState.Error
        || lazyPostItems.loadState.append is LoadState.Error
    ) {
        val loadStateError = lazyPostItems.loadState.refresh as LoadState.Error
        val errorMessage = loadStateError.error.localizedMessage
            ?: stringResource(R.string.message_unexpected_error)

        ErrorAlertDialog(
            errorMessage = errorMessage,
            onRetryClicked = { lazyPostItems.retry() },
            onDismissRequest = {
                // Do nothing
            }
        )
    }
}

@Preview
@Composable
fun DefaultLightPostList() {
    val posts: Flow<PagingData<Post>> = flowOf(
        PagingData.from(MockUiModels.fakeDefaultUiPostList)
    )

    JustPostsTheme {
        PostList(
            posts = posts,
            // TODO Remove below list parameter whenever the list parameter above works for the Preview
            postsTest = MockUiModels.fakeDefaultUiPostList
        )
    }
}

@Preview
@Composable
fun DefaultDarkPostList() {
    val posts: Flow<PagingData<Post>> = flowOf(
        PagingData.from(MockUiModels.fakeDefaultUiPostList)
    )

    JustPostsTheme(isDarkTheme = true) {
        PostList(
            posts = posts,
            // TODO Remove below list parameter whenever the list parameter above works for the Preview
            postsTest = MockUiModels.fakeDefaultUiPostList
        )
    }
}
