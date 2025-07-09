

package com.diceroll.diceroller.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.diceroll.diceroller.ui.screens.GameScreen
import com.diceroll.diceroller.ui.screens.HistoryScreen
import com.diceroll.diceroller.ui.screens.MenuScreen
import com.diceroll.diceroller.ui.screens.SplashScreen
import com.diceroll.diceroller.viewmodel.GameViewModel


sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Menu : Screen("menu_screen")
    object Game : Screen("game_screen")
    object History : Screen("history_screen")
}

@Composable
fun AppNavigation() {
    val gameViewModel: GameViewModel = viewModel()
    NavHost(
        navController = LocalNavController.current,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = LocalNavController.current)
        }
        composable(Screen.Menu.route) {
            MenuScreen(navController = LocalNavController.current)
        }
        composable(Screen.Game.route) {
            GameScreen(
                navController = LocalNavController.current,
                gameViewModel = gameViewModel
            )
        }
        composable(Screen.History.route) {
            HistoryScreen(
                navController = LocalNavController.current,
                gameViewModel = gameViewModel
            )
        }
    }
}



val LocalNavController = staticCompositionLocalOf<NavHostController> {
    error("No NavController found!")
}