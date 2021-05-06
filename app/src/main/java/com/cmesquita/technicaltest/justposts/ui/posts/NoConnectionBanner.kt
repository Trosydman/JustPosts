package com.cmesquita.technicaltest.justposts.ui.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.ui.theme.JustPostsTheme
import java.util.*

@Composable
fun NoConnectionBanner() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.large)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.padding(end = dimensionResource(R.dimen.large)),
            painter = painterResource(R.drawable.ic_no_internet),
            contentDescription = stringResource(R.string.message_no_internet_connection),
            tint = MaterialTheme.colors.error
        )

        Text(
            text = stringResource(R.string.message_no_internet_connection)
                .toUpperCase(Locale.getDefault()),
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.overline
        )
    }
}

@Preview
@Composable
fun DefaultLightNoConnectionBanner() {
    JustPostsTheme {
        NoConnectionBanner()
    }
}

@Preview
@Composable
fun DefaultDarkNoConnectionBanner() {
    JustPostsTheme(isDarkTheme = true) {
        NoConnectionBanner()
    }
}
