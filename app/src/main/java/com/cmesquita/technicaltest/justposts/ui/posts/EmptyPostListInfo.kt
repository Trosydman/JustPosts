package com.cmesquita.technicaltest.justposts.ui.posts

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.ui.theme.JustPostsTheme

@Composable
fun EmptyPostListInfo(onRetryClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .size(80.dp)
                .aspectRatio(1f)
                .padding(bottom = 4.dp),
            painter = painterResource(id = R.drawable.ic_twotone_empty_sticky_note),
            contentDescription = "Empty note icon"
        )
        Text(text = stringResource(id = R.string.message_empty_posts_list))
        Button(
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.xxx_large)),
            onClick = onRetryClicked
        ) {
            Text(text = stringResource(id = R.string.action_retry))
        }
    }
}

@Preview
@Composable
fun DefaultLightEmptyPostListInfo() {
    JustPostsTheme {
        EmptyPostListInfo(onRetryClicked = {
            // TODO
        })
    }
}

@Preview
@Composable
fun DefaultDarkEmptyPostListInfo() {
    JustPostsTheme(isDarkTheme = true) {
        EmptyPostListInfo(onRetryClicked = {
            // TODO
        })
    }
}
