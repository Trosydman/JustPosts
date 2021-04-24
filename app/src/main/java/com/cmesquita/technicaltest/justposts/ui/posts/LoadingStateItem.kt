package com.cmesquita.technicaltest.justposts.ui.posts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cmesquita.technicaltest.justposts.ui.custom.LoadingView
import com.cmesquita.technicaltest.justposts.ui.theme.JustPostsTheme

@Composable
fun LoadingStateItem() {
    Box(modifier = Modifier.fillMaxWidth()) {
        LoadingView(modifier = Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
fun DefaultLightLoadingStateItem() {
    JustPostsTheme {
        LoadingStateItem()
    }
}

@Preview
@Composable
fun DefaultDarkLoadingStateItem() {
    JustPostsTheme(isDarkTheme = true) {
        LoadingStateItem()
    }
}
