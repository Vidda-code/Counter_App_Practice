package com.example.counterapppractice.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.counterapppractice.CounterViewModel

sealed class Screen(val route: String){
    data object CounterScreen : Screen("counter")
    data object HistoryScreen : Screen("history")
}

@Composable
fun NavGraphHost(
    viewModel: CounterViewModel = viewModel()
) {
    val navController = rememberNavController()
    val state by viewModel.state.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Screen.CounterScreen.route
    ) {
        composable(route = Screen.CounterScreen.route) {
            CounterScreen(
                count = state.count,
                label = state.label,
                onIncrement = { viewModel.increment() },
                onDecrement = { viewModel.decrement() },
                onReset = { viewModel.reset() },
                onHistory = { navController.navigate(Screen.HistoryScreen.route) }
            )
        }
        composable(route = Screen.HistoryScreen.route) {
            HistoryScreen(
                history = state.history
            )
        }
    }
}