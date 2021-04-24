package com.cmesquita.technicaltest.justposts.ui.posts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.ui.theme.JustPostsTheme

@Composable
fun ErrorStateItem(
    onRetryClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.x_large)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.message_error_loadstate),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )
        Button(
            modifier = Modifier.padding(top = dimensionResource(R.dimen.x_large)),
            onClick = { onRetryClicked() }
        ) {
            Text(text = stringResource(R.string.action_retry))
        }
    }
}

@Preview
@Composable
fun DefaultLightErrorStateItem() {
    JustPostsTheme {
        ErrorStateItem(
            onRetryClicked = {
                // Do nothing
            }
        )
    }
}

@Preview
@Composable
fun DefaultDarkErrorStateItem() {
    JustPostsTheme(isDarkTheme = true) {
        ErrorStateItem(
            onRetryClicked = {
                // Do nothing
            }
        )
    }
}
