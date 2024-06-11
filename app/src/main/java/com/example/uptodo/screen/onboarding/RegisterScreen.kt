package com.example.uptodo.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uptodo.R

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp),
    ) {

        Image(imageVector = Icons.Outlined.KeyboardArrowLeft, contentDescription = "back")
        Text(text = stringResource(id = R.string.register))

        Text(text = stringResource(id = R.string.username))
        OutlinedTextField(value = "", onValueChange = {})

        Text(text = stringResource(id = R.string.password))
        OutlinedTextField(value = "", onValueChange = {})


        Text(text = stringResource(id = R.string.confirm_password))
        OutlinedTextField(value = "", onValueChange = {})

        Button(
            shape = RectangleShape,
            modifier = Modifier.fillMaxWidth(),
            onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.register))
        }

        Row {

        }

    }
}

@Preview
@Composable
private fun ShowRegisterScreen() {
    RegisterScreen()
}