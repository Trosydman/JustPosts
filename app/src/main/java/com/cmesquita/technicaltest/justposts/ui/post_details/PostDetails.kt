package com.cmesquita.technicaltest.justposts.ui.post_details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.ui.model.Post
import com.cmesquita.technicaltest.justposts.ui.model.User

@Composable
fun PostDetails(
    post: Post,
    onCloseButtonClicked: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 24.dp
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    text = post.title ?: stringResource(id = R.string.message_no_post_title),
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onSurface,
//                    enabled = post.hasTitle()
                )

                IconButton(
                    onClick = onCloseButtonClicked,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_keyboard_arrow_down),
                        contentDescription = "Close button"
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                if (post.user.isAnonymous() || post.user.name != null) {
                    Text(
                        text = post.user.name
                            ?: stringResource(id = R.string.message_anonymous_author),
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.onSurface,
//                        enabled = post.user.isAnonymous()
                    )
                }

                if (!post.user.isAnonymous() && post.user.userName != null) {
                    Text(
                        modifier = Modifier.padding(top = 2.dp),
                        text = post.user.userName,
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.onSurface,
                    )
                }
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .verticalScroll(rememberScrollState()),
                text = if (post.hasBody()) {
                    post.body!!
                } else {
                    stringResource(id = R.string.message_no_post_body)
                },
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
//                enabled = post.hasBody()
            )
        }
    }
}

@Preview
@Composable
fun DefaultPostDetails() {
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
    PostDetails(
        post = michaelScottPost,
        onCloseButtonClicked = {
            // Do nothing
        }
    )
}

@Preview
@Composable
fun PostDetailsWithoutAuthor() {
    val anonymousPost = Post(
        id = null,
        title = "Title of a super super super super large Post",
        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec metus risus, commodo vel turpis in, tristique porttitor elit. Nam lectus nisi, vehicula nec libero id, tristique ultricies metus. Phasellus congue magna sed ex malesuada, at pretium quam efficitur. Sed id nunc sed purus interdum ornare. Vestibulum quam sem, faucibus quis erat molestie, viverra efficitur nunc. Maecenas fermentum, tellus sed maximus commodo, dolor elit scelerisque enim, eget tincidunt arcu ante quis enim. Fusce posuere tincidunt neque ut sollicitudin. Sed vehicula lectus id rhoncus posuere. Nullam condimentum est at consequat tempus. Donec at maximus massa, eget congue arcu. Sed non facilisis odio. Pellentesque fringilla enim ipsum, at suscipit ligula suscipit non. Nullam sollicitudin luctus vehicula. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin malesuada facilisis elit, ac eleifend leo suscipit quis.\n" +
                "\n" +
                "Proin gravida tempor neque ac interdum. Vivamus vehicula dapibus eleifend. Maecenas convallis, massa a volutpat ultricies, augue enim semper augue, ut ultricies nisl justo a eros. Curabitur quis urna sed sem placerat commodo. Nullam tincidunt gravida nisl id ultrices. Etiam aliquet vitae dolor id venenatis. Vestibulum at odio sit amet purus porttitor sodales at eget velit. Aliquam eleifend arcu sed sem tempor, vel facilisis enim tempus. Ut in tortor vel elit feugiat commodo quis vel sem. Donec suscipit malesuada lectus, sed ullamcorper nisl convallis quis. Vivamus in leo in nunc iaculis condimentum. Mauris tempor sem at sapien porta tempus. Integer id scelerisque mi, at dignissim arcu. Maecenas cursus in metus ut ullamcorper.",
        user = User(
            name = null,
            userName = null
        )
    )
    PostDetails(
        post = anonymousPost,
        onCloseButtonClicked = {
            // Do nothing
        }
    )
}

@Preview
@Composable
fun PostDetailsWithoutAuthorUsername() {
    val michaelScottPost = Post(
        id = null,
        title = "Title of a super super super super large Post",
        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec metus risus, commodo vel turpis in, tristique porttitor elit. Nam lectus nisi, vehicula nec libero id, tristique ultricies metus. Phasellus congue magna sed ex malesuada, at pretium quam efficitur. Sed id nunc sed purus interdum ornare. Vestibulum quam sem, faucibus quis erat molestie, viverra efficitur nunc. Maecenas fermentum, tellus sed maximus commodo, dolor elit scelerisque enim, eget tincidunt arcu ante quis enim. Fusce posuere tincidunt neque ut sollicitudin. Sed vehicula lectus id rhoncus posuere. Nullam condimentum est at consequat tempus. Donec at maximus massa, eget congue arcu. Sed non facilisis odio. Pellentesque fringilla enim ipsum, at suscipit ligula suscipit non. Nullam sollicitudin luctus vehicula. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin malesuada facilisis elit, ac eleifend leo suscipit quis.\n" +
                "\n" +
                "Proin gravida tempor neque ac interdum. Vivamus vehicula dapibus eleifend. Maecenas convallis, massa a volutpat ultricies, augue enim semper augue, ut ultricies nisl justo a eros. Curabitur quis urna sed sem placerat commodo. Nullam tincidunt gravida nisl id ultrices. Etiam aliquet vitae dolor id venenatis. Vestibulum at odio sit amet purus porttitor sodales at eget velit. Aliquam eleifend arcu sed sem tempor, vel facilisis enim tempus. Ut in tortor vel elit feugiat commodo quis vel sem. Donec suscipit malesuada lectus, sed ullamcorper nisl convallis quis. Vivamus in leo in nunc iaculis condimentum. Mauris tempor sem at sapien porta tempus. Integer id scelerisque mi, at dignissim arcu. Maecenas cursus in metus ut ullamcorper.",
        user = User(
            name = "Michael Scott",
            userName = null
        )
    )
    PostDetails(
        post = michaelScottPost,
        onCloseButtonClicked = {
            // Do nothing
        }
    )
}

@Preview
@Composable
fun PostDetailsWithoutAuthorName() {
    val michaelScottPost = Post(
        id = null,
        title = "Title of a super super super super large Post",
        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec metus risus, commodo vel turpis in, tristique porttitor elit. Nam lectus nisi, vehicula nec libero id, tristique ultricies metus. Phasellus congue magna sed ex malesuada, at pretium quam efficitur. Sed id nunc sed purus interdum ornare. Vestibulum quam sem, faucibus quis erat molestie, viverra efficitur nunc. Maecenas fermentum, tellus sed maximus commodo, dolor elit scelerisque enim, eget tincidunt arcu ante quis enim. Fusce posuere tincidunt neque ut sollicitudin. Sed vehicula lectus id rhoncus posuere. Nullam condimentum est at consequat tempus. Donec at maximus massa, eget congue arcu. Sed non facilisis odio. Pellentesque fringilla enim ipsum, at suscipit ligula suscipit non. Nullam sollicitudin luctus vehicula. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin malesuada facilisis elit, ac eleifend leo suscipit quis.\n" +
                "\n" +
                "Proin gravida tempor neque ac interdum. Vivamus vehicula dapibus eleifend. Maecenas convallis, massa a volutpat ultricies, augue enim semper augue, ut ultricies nisl justo a eros. Curabitur quis urna sed sem placerat commodo. Nullam tincidunt gravida nisl id ultrices. Etiam aliquet vitae dolor id venenatis. Vestibulum at odio sit amet purus porttitor sodales at eget velit. Aliquam eleifend arcu sed sem tempor, vel facilisis enim tempus. Ut in tortor vel elit feugiat commodo quis vel sem. Donec suscipit malesuada lectus, sed ullamcorper nisl convallis quis. Vivamus in leo in nunc iaculis condimentum. Mauris tempor sem at sapien porta tempus. Integer id scelerisque mi, at dignissim arcu. Maecenas cursus in metus ut ullamcorper.",
        user = User(
            name = null,
            userName = "@mscott"
        )
    )
    PostDetails(
        post = michaelScottPost,
        onCloseButtonClicked = {
            // Do nothing
        }
    )
}
