package com.cmesquita.technicaltest.justposts.ui.custom

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.cmesquita.technicaltest.justposts.R

@Composable
fun LoadingView(
    modifier: Modifier = Modifier.fillMaxSize()
) {
    Box(modifier = modifier) {
        CircularProgressIndicator(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.x_large))
                .size(dimensionResource(R.dimen.xxxx_large))
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun DefaultLoadingView() {
    LoadingView()
}

@Preview
@Composable
fun FullWidthLoadingView() {
    LoadingView(
        modifier = Modifier.fillMaxWidth()
    )
}
