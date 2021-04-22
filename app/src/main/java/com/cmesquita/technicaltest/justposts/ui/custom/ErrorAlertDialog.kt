package com.cmesquita.technicaltest.justposts.ui.custom

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cmesquita.technicaltest.justposts.R

@Composable
fun ErrorAlertDialog(
    errorMessage: String,
    onRetryClicked: () -> Unit,
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Text(text = stringResource(R.string.title_unexpected_error))
        },
        text = {
            Text(text = stringResource(R.string.message_unexpected_error, errorMessage))
        },
        confirmButton = {
            // Do not show
        },
        dismissButton = {
            Button(onClick = onRetryClicked) {
                Text(text = stringResource(R.string.action_retry))
            }
        }
    )
}

@Preview
@Composable
fun DefaultErrorAlertDialog() {
    ErrorAlertDialog(
        errorMessage = "This is a error message for the default preview.",
        onRetryClicked = { /*TODO*/ },
        onDismissRequest = { /*TODO*/ }
    )
}
