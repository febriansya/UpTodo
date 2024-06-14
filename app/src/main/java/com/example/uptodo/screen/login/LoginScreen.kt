package com.example.uptodo.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.example.uptodo.R
import com.example.uptodo.screen.component.BottomSheetFinger
import com.example.uptodo.screen.register.LineOrSpacer
import com.example.uptodo.ui.theme.AppTheme
import com.example.uptodo.ui.theme.black01

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showSheet by remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current
    LoginContentScreen(
        navController,
        username,
        focusManager,
        password,
        confirmPassword,
        showSheet
    ) {
        showSheet = it
    }

}


@Composable
private fun LoginContentScreen(
    navController: NavController,
    username: String,
    focusManager: FocusManager,
    password: String,
    confirmPassword: String,
    showSheet: Boolean,
    setShowSheet: (Boolean) -> Unit = {},
) {
    var username1 = username
    var password1 = password
    var confirmPassword1 = confirmPassword

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(black01)

    ) {
        val (btnBack, title, desc, columInput, sheet) = createRefs()

        if (showSheet) {
            BottomSheetFinger(modifier = Modifier.constrainAs(
                sheet
            ) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }, onClose = {
                setShowSheet(false)
            })
        }



        IconButton(modifier = Modifier.constrainAs(btnBack) {
            top.linkTo(parent.top, margin = 50.dp)
            start.linkTo(parent.start)
            bottom.linkTo(columInput.top)
            width = Dimension.fillToConstraints
        }, onClick = { navController.popBackStack() }) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "Back",
                tint = Color.White
            )
        }

        Column(
            Modifier
                .constrainAs(columInput) {
                    top.linkTo(btnBack.bottom)
                    bottom.linkTo(parent.bottom)
                }
                .fillMaxSize()
                .padding(horizontal = 12.dp)
                .verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.height(AppTheme.dimens.large))
            Text(
                text = stringResource(id = R.string.login_lowercase),
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(AppTheme.dimens.large))
            Text(text = stringResource(id = R.string.username), color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = username1, onValueChange = {
                    username1 = it
                }, Modifier.fillMaxWidth(), colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White, unfocusedTextColor = Color.White
                ), maxLines = 1, keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }), keyboardOptions = KeyboardOptions.Default.copy(
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            Spacer(modifier = Modifier.height(25.dp))

            Text(text = stringResource(id = R.string.password), color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = password1, onValueChange = { text ->
                    password1 = text
                }, Modifier.fillMaxWidth(), colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White, unfocusedTextColor = Color.DarkGray
                ), maxLines = 1, visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(25.dp))

            Text(text = stringResource(id = R.string.confirm_password), color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = confirmPassword1,
                onValueChange = { confirmPassword1 = it },
                Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White, unfocusedTextColor = Color.DarkGray
                ),
                maxLines = 1,
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(40.dp))
            Button(shape = RoundedCornerShape(4.dp),
                modifier = Modifier.fillMaxWidth(),
                onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(id = R.string.login),
                    modifier = Modifier.padding(12.dp),
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(AppTheme.dimens.mediumLarge))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                LineOrSpacer(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 12.dp)
                )
                Text(text = stringResource(id = R.string.or), color = Color.White)
                LineOrSpacer(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 12.dp)
                )
            }

            Spacer(modifier = Modifier.height(AppTheme.dimens.mediumLarge))

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                shape = RectangleShape,
                onClick = {
                    setShowSheet(true)
                },
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = "ic_google"
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = stringResource(id = R.string.login_with_google))
                }
            }

            Spacer(modifier = Modifier.height(17.dp))

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                shape = RectangleShape,
                onClick = {

                },
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_apple),
                        contentDescription = "ic_apple"
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = stringResource(id = R.string.login_with_apple))
                }
            }

            Spacer(modifier = Modifier.height(46.dp))

            TextButton(
                onClick = {
                    navController.navigate("register")
                }, modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = stringResource(id = R.string.not_have_account), color = Color.White)
            }

        }
    }
}


