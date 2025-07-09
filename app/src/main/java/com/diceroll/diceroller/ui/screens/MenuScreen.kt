// ui/screens/MenuScreen.kt

package com.diceroll.diceroller.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.diceroll.diceroller.ui.navigation.Screen

@Composable
fun MenuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome to Dice Roller!",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(64.dp))

        // Start Game Button
        Button(
            onClick = { navController.navigate(Screen.Game.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Icon(Icons.Default.PlayArrow, contentDescription = "Start Game")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Start Game")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // View History Button
        OutlinedButton(
            onClick = { navController.navigate(Screen.History.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Icon(Icons.Default.History, contentDescription = "View History")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "View History")
        }
    }
}