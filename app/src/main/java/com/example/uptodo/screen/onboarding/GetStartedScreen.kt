package com.example.uptodo.screen.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.uptodo.R
import com.example.uptodo.ui.theme.black01

@Composable
fun GetStartedScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(black01),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(59.dp))
        Text(
            text = stringResource(id = R.string.welcome_todo),
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(26.dp))

        Text(
            text = stringResource(id = R.string.welcome_desc),
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = Color.White
        )

        Button(
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            onClick = {
                navController.navigate("login")
            }) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )
        }

        OutlinedButton(
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp), onClick = {
                navController.navigate("register")
            }) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = stringResource(id = R.string.create_account),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(13.dp))
    }
}
