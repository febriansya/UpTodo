package com.example.uptodo.screen.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.uptodo.R
import com.example.uptodo.ui.theme.AppTheme
import com.example.uptodo.ui.theme.black01


@Composable
fun GetStartedScreen(modifier: Modifier = Modifier, navController: NavController) {
    GetStartedPotrait(navController)
}

@Composable
private fun GetStartedPotrait(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(black01)
            .padding(AppTheme.dimens.mediumLarge),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(59.dp))
        Text(
            text = stringResource(id = R.string.welcome_todo),
            style = MaterialTheme.typography.displayMedium,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(26.dp))

        Text(
            text = stringResource(id = R.string.welcome_desc),
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            color = Color.White
        )

        Button(
            shape = RoundedCornerShape(AppTheme.dimens.small),
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                navController.navigate("login")
            }) {
            Text(
                modifier = Modifier.padding(vertical = AppTheme.dimens.mediumLarge),
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.bodySmall,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(AppTheme.dimens.medium))
        OutlinedButton(
            shape = RoundedCornerShape(AppTheme.dimens.small),
            modifier = Modifier
                .fillMaxWidth(), onClick = {
                navController.navigate("register")
            }) {
            Text(
                modifier = Modifier.padding(vertical = AppTheme.dimens.mediumLarge),
                text = stringResource(id = R.string.create_account),
                style = MaterialTheme.typography.bodySmall,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(13.dp))
    }
}
