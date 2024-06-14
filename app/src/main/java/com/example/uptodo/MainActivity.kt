package com.example.uptodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uptodo.screen.onboarding.GetStartedScreen
import com.example.uptodo.screen.onboarding.HomeScreen
import com.example.uptodo.screen.onboarding.LoginScreen
import com.example.uptodo.screen.onboarding.OnBoardingScreen
import com.example.uptodo.screen.onboarding.RegisterScreen
import com.example.uptodo.screen.onboarding.SplashScreen
import com.example.uptodo.ui.theme.UpTodoTheme
import com.example.uptodo.ui.theme.rememberWindowSizeClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val window = rememberWindowSizeClass()
            UpTodoTheme(window) {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
//                    if (AppTheme.orientation == Orientation.Portrait)
                    NavHost(
                        navController = navController,
                        startDestination = "splash",
                        modifier = Modifier.padding(padding)
                    ) {

                        composable("get-started") {
                            GetStartedScreen(navController = navController)
                        }
                        composable("splash") {
                            SplashScreen(navController = navController, context = this@MainActivity)
                        }
                        composable("onboarding") {
                            OnBoardingScreen(
                                navController = navController,
                                context = this@MainActivity
                            )
                        }
                        composable("home") {
                            HomeScreen()
                        }

                        composable("login") {
                            LoginScreen(navController = navController)
                        }

                        composable("register") {
                            RegisterScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

