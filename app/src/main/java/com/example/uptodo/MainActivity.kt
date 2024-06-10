package com.example.uptodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uptodo.screen.onboarding.HomeScreen
import com.example.uptodo.screen.onboarding.OnBoardingScreen
import com.example.uptodo.screen.onboarding.SplashScreen
import com.example.uptodo.ui.theme.UpTodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UpTodoTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    val padding = padding
                    NavHost(
                        navController = navController,
                        startDestination = "splash",
                        modifier = Modifier.padding(padding)
                    ) {
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
                    }
                }
            }
        }
    }
}

