package com.cmesquita.technicaltest.justposts.ui.posts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.ui.model.Post
import com.cmesquita.technicaltest.justposts.ui.model.User

@Composable
fun PostItem(
    post: Post,
    onItemClicked: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.medium))
            .clickable { onItemClicked() },
    ) {
        Box(
            modifier = Modifier.padding(dimensionResource(R.dimen.x_large))
        ) {
            Row {
                Icon(
                    modifier = Modifier.size(48.dp),
                    painter = painterResource(R.drawable.ic_twotone_sticky_note),
                    contentDescription = null
                )

                Column(
                    modifier = Modifier.padding(start = dimensionResource(R.dimen.x_large))
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = post.title ?: stringResource(R.string.message_no_post_title),
                        color = MaterialTheme.colors.onSurface,
                        style = MaterialTheme.typography.h5,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = dimensionResource(R.dimen.large)),
                        text = post.body?.take(integerResource(R.integer.max_post_body_character))
                            ?: stringResource(R.string.message_no_post_body),
                        color = MaterialTheme.colors.onSurface,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPostItem() {
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

    PostItem(
        post = michaelScottPost,
        onItemClicked = {
            // Do nothing
        }
    )
}

@Preview
@Composable
fun PostItemWithoutTitle() {
    val michaelScottPost = Post(
        id = null,
        title = null,
        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec metus risus, commodo vel turpis in, tristique porttitor elit. Nam lectus nisi, vehicula nec libero id, tristique ultricies metus. Phasellus congue magna sed ex malesuada, at pretium quam efficitur. Sed id nunc sed purus interdum ornare. Vestibulum quam sem, faucibus quis erat molestie, viverra efficitur nunc. Maecenas fermentum, tellus sed maximus commodo, dolor elit scelerisque enim, eget tincidunt arcu ante quis enim. Fusce posuere tincidunt neque ut sollicitudin. Sed vehicula lectus id rhoncus posuere. Nullam condimentum est at consequat tempus. Donec at maximus massa, eget congue arcu. Sed non facilisis odio. Pellentesque fringilla enim ipsum, at suscipit ligula suscipit non. Nullam sollicitudin luctus vehicula. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin malesuada facilisis elit, ac eleifend leo suscipit quis.\n" +
                "\n" +
                "Proin gravida tempor neque ac interdum. Vivamus vehicula dapibus eleifend. Maecenas convallis, massa a volutpat ultricies, augue enim semper augue, ut ultricies nisl justo a eros. Curabitur quis urna sed sem placerat commodo. Nullam tincidunt gravida nisl id ultrices. Etiam aliquet vitae dolor id venenatis. Vestibulum at odio sit amet purus porttitor sodales at eget velit. Aliquam eleifend arcu sed sem tempor, vel facilisis enim tempus. Ut in tortor vel elit feugiat commodo quis vel sem. Donec suscipit malesuada lectus, sed ullamcorper nisl convallis quis. Vivamus in leo in nunc iaculis condimentum. Mauris tempor sem at sapien porta tempus. Integer id scelerisque mi, at dignissim arcu. Maecenas cursus in metus ut ullamcorper.",
        user = User(
            name = "Michael Scott",
            userName = "@mscott"
        )
    )
    PostItem(
        post = michaelScottPost,
        onItemClicked = {
            // Do nothing
        }
    )
}

@Preview
@Composable
fun PostItemWithoutBody() {
    val michaelScottPost = Post(
        id = null,
        title = "Title of a super super super super large Post",
        body = null,
        user = User(
            name = "Michael Scott",
            userName = "@mscott"
        )
    )
    PostItem(
        post = michaelScottPost,
        onItemClicked = {
            // Do nothing
        }
    )
}
