package com.example.uptodo.screen.onboarding

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.uptodo.MainActivity
import com.example.uptodo.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, context: MainActivity) {

    val alpha = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        alpha.animateTo(
            1f,
            animationSpec = androidx.compose.animation.core.tween(
                durationMillis = 1000
            )
        )
        delay(3000)
        if (onBoardingScreenIsFinished(context)) {
            navController.popBackStack()
            navController.navigate("get-started")
        } else {
            navController.popBackStack()
            navController.navigate("onBoarding")
        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
    ) {
        LoaderAnimation(modifier = Modifier.size(400.dp), anim = R.raw.splash)
    }
}

@Composable
fun LoaderAnimation(modifier: Modifier = Modifier, anim: Int) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(anim))
    LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever)
}

private fun onBoardingScreenIsFinished(context: MainActivity): Boolean {
    val sharedPreferences = context.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean("finished", false)
}

