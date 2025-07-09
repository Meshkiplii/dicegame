package com.diceroll.diceroller.ui.screens

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.diceroll.diceroller.R
import com.diceroll.diceroller.viewmodel.GameViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(navController: NavController, gameViewModel: GameViewModel) {
    val uiState by gameViewModel.uiState.collectAsStateWithLifecycle()
    var rotationState by remember { mutableStateOf(0f) }

    
    var hasRolled by remember { mutableStateOf(false) }

    val rotation = animateFloatAsState(
        targetValue = rotationState,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = "diceRotation"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Roll the Dice!") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            DiceImage(diceValue = uiState.currentDiceValue, rotation = rotation.value)

            Spacer(modifier = Modifier.height(24.dp)) 

            
            if (hasRolled) {
                Text(
                    text = stringResource(R.string.dice_rolled_result, uiState.currentDiceValue),
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 24.dp) 
                )
            } else {
                
                Text(
                    text = stringResource(R.string.press_roll_to_start),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }

            Button(
                onClick = {
                    
                    rotationState += (720..1080).random().toFloat()
                    gameViewModel.rollDice()
                    hasRolled = true 
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(R.string.roll),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}

@Composable
fun DiceImage(diceValue: Int, rotation: Float, modifier: Modifier = Modifier) {
    val imageResource = when (diceValue) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = "Dice showing $diceValue",
        modifier = modifier
            .size(200.dp)
            .rotate(rotation)
    )
}
