package com.diceroll.diceroller.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random


data class GameUiState(
    val currentDiceValue: Int = 1,
    val rollHistory: List<Int> = emptyList()
)

class GameViewModel : ViewModel() {

    
    private val _uiState = MutableStateFlow(GameUiState())

    
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    fun rollDice() {
        val newDiceValue = Random.nextInt(1, 7)
        _uiState.update { currentState ->
            currentState.copy(
                currentDiceValue = newDiceValue,
                
                rollHistory = listOf(newDiceValue) + currentState.rollHistory
            )
        }
    }
}