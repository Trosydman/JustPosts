package com.cmesquita.technicaltest.justposts.ui.posts

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    connectionState: State<Boolean?>,
    onPostItemClicked: (Post) -> Unit,
    // TODO Remove below list whenever the list above works for the Preview
    postsTest: List<Post>? = null
) {
    val lazyPostItems: LazyPagingItems<Post> = posts.collectAsLazyPagingItems()

    val isLoading = lazyPostItems.loadState.refresh is LoadState.Loading
    val isEmpty = lazyPostItems.loadState.refresh is LoadState.NotLoading &&
            lazyPostItems.loadState.append.endOfPaginationReached && lazyPostItems.itemCount < 1
    val loadStateError = when {
        lazyPostItems.loadState.source.append is LoadState.Error ->
            lazyPostItems.loadState.source.append as LoadState.Error

        lazyPostItems.loadState.source.prepend is LoadState.Error ->
            lazyPostItems.loadState.source.prepend as LoadState.Error

        lazyPostItems.loadState.source.refresh is LoadState.Error ->
            lazyPostItems.loadState.source.refresh as LoadState.Error

        else -> null
    }
    val errorExists = connectionState.value == true && loadStateError != null

    if (isLoading) {
        LoadingView()
    }

    if (isEmpty) {
        EmptyPostListInfo(onRetryClicked = {
            lazyPostItems.retry()
        })
    } else {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            when (lazyPostItems.loadState.prepend) {
                is LoadState.Loading -> {
                    item { LoadingStateItem() }
                }
                is LoadState.Error -> {
                    item {
                        ErrorStateItem(
                            onRetryClicked = {
                                lazyPostItems.retry()
                            }
                        )
                    }
                }
                else -> {
                    // TODO
                }
            }

            if (postsTest != null) {
                items(postsTest) { post ->
                    PostItem(
                        post = post,
                        onItemClicked = { onPostItemClicked(post) }
                    )
                }
            } else {
                items(lazyPostItems) { post ->
                    post?.let {
                        PostItem(
                            post = it,
                            onItemClicked = { onPostItemClicked(post) }
                        )
                    }
                }
            }

            with(lazyPostItems) {
                when {
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
    }

    if (errorExists) {
        val errorMessage = loadStateError!!.error.localizedMessage
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
    val connectionState = remember {
        mutableStateOf(true)
    }

    JustPostsTheme {
        PostList(
            posts = posts,
            connectionState = connectionState as State<Boolean?>,
            onPostItemClicked = {
                // TODO
            },
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
    val connectionState = remember {
        mutableStateOf(true)
    }

    JustPostsTheme(isDarkTheme = true) {
        PostList(
            posts = posts,
            connectionState = connectionState as State<Boolean?>,
            onPostItemClicked = {
                // TODO
            },
            // TODO Remove below list parameter whenever the list parameter above works for the Preview
            postsTest = MockUiModels.fakeDefaultUiPostList
        )
    }
}
