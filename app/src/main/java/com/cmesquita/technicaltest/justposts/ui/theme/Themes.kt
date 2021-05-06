package com.cmesquita.technicaltest.justposts.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import com.cmesquita.technicaltest.justposts.ui.custom.LoadingView
import com.cmesquita.technicaltest.justposts.ui.model.MockUiModels
import com.cmesquita.technicaltest.justposts.ui.model.Post
import com.cmesquita.technicaltest.justposts.ui.model.User
import com.cmesquita.technicaltest.justposts.ui.post_details.PostDetails
import com.cmesquita.technicaltest.justposts.ui.posts.ErrorStateItem
import com.cmesquita.technicaltest.justposts.ui.posts.LoadingStateItem
import com.cmesquita.technicaltest.justposts.ui.posts.PostList
import com.cmesquita.technicaltest.justposts.ui.theme.Colors.JustPostsDarkColors
import com.cmesquita.technicaltest.justposts.ui.theme.Colors.JustPostsLightColors
import com.cmesquita.technicaltest.justposts.ui.theme.Shapes.JustPostsShapes
import com.cmesquita.technicaltest.justposts.ui.theme.Typography.WorkSansTypography
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

private const val PLAYGROUND_MAX_WIDTH = 1200

@Composable
fun JustPostsTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (isDarkTheme) {
            JustPostsDarkColors
        } else {
            JustPostsLightColors
        },
        typography = WorkSansTypography,
        shapes = JustPostsShapes,
    ) {
        content()
    }
}

@Composable
private fun ThemePlayground() {
    val columnGridWidth = PLAYGROUND_MAX_WIDTH / 3
    val connectionState = remember {
        mutableStateOf(true)
    }

    val posts: Flow<PagingData<Post>> = flowOf(
        PagingData.from(MockUiModels.fakeDefaultUiPostList)
    )

    val michaelScottPost = Post(
        id = null,
        title = "Title of a super super super super large Post",
        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec metus risus, commodo vel turpis in, tristique porttitor elit. Nam lectus nisi, vehicula nec libero id, tristique ultricies metus. Phasellus congue magna sed ex malesuada, at pretium quam efficitur. Sed id nunc sed purus interdum ornare. Vestibulum quam sem, faucibus quis erat molestie, viverra efficitur nunc. Maecenas fermentum, tellus sed maximus commodo, dolor elit scelerisque enim, eget tincidunt arcu ante quis enim. Fusce posuere tincidunt neque ut sollicitudin. Sed vehicula lectus id rhoncus posuere. Nullam condimentum est at consequat tempus. Donec at maximus massa, eget congue arcu. Sed non facilisis odio. Pellentesque fringilla enim ipsum, at suscipit ligula suscipit non. Nullam sollicitudin luctus vehicula. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin malesuada facilisis elit, ac eleifend leo suscipit quis.\n" +
                "\n" +
                "Proin gravida tempor neque ac interdum. Vivamus vehicula dapibus eleifend. Maecenas convallis, massa a volutpat ultricies, augue enim semper augue, ut ultricies nisl justo a eros. Curabitur quis urna sed sem placerat commodo. Nullam tincidunt gravida nisl id ultrices. Etiam aliquet vitae dolor id venenatis. Vestibulum at odio sit amet purus porttitor sodales at eget velit. Aliquam eleifend arcu sed sem tempor, vel facilisis enim tempus. Ut in tortor vel elit feugiat commodo quis vel sem. Donec suscipit malesuada lectus, sed ullamcorper nisl convallis quis. Vivamus in leo in nunc iaculis condimentum. Mauris tempor sem at sapien porta tempus. Integer id scelerisque mi, at dignissim arcu. Maecenas cursus in metus ut ullamcorper.",
        user = User(
            name = "Michael Scott",
            userName = "@mscott"
        )
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .width(columnGridWidth.dp)
                .fillMaxHeight()
        ) {
            PostList(
                posts = posts,
                connectionState = connectionState as State<Boolean?>,
                onPostItemClicked = {
                    // Do nothing
                },
                postsTest = MockUiModels.fakeDefaultUiPostList
            )
            LoadingStateItem()
            ErrorStateItem(onRetryClicked = { })
        }

        Box(modifier = Modifier.width(columnGridWidth.dp)) {
            PostDetails(
                post = michaelScottPost,
                onCloseButtonClicked = { }
            )
        }

        Box(modifier = Modifier.width(columnGridWidth.dp)) {
            LoadingView()
        }
    }
}


@Preview(widthDp = PLAYGROUND_MAX_WIDTH)
@Composable
fun JustPostThemeLightPlayground() {

    Column {
        JustPostsTheme {
            ThemePlayground()
        }
    }
}

@Preview(widthDp = PLAYGROUND_MAX_WIDTH)
@Composable
fun JustPostThemeDarkPlayground() {

    Column {
        JustPostsTheme(isDarkTheme = true) {
            ThemePlayground()
        }
    }
}
