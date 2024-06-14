package com.example.uptodo.screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.uptodo.R
import com.example.uptodo.ui.theme.AppTheme
import com.example.uptodo.ui.theme.black01

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetFinger(
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    ModalBottomSheet(

        containerColor = black01,
        sheetState = modalBottomSheetState,
        onDismissRequest = {
            onClose()
        }) {
        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(AppTheme.dimens.large),
            painter = painterResource(id = R.drawable.ic_finger_white),
            contentDescription = "finger"
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.finger_desc),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Color.White,
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(51.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(AppTheme.dimens.large),
        ) {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.cancel))
            }

            Button(
                shape = RectangleShape,
                onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.use_password))
            }
        }
    }
}