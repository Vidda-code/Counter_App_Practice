package com.example.counterapppractice

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class Counterstate(
    val count: Int = 0,
    val history: List<String> = emptyList()
) {
    val label: String
        get() = when {
            count > 0 -> "Positive"
            count < 0 -> "Negative"
            else -> "Zero"
        }
}

class CounterViewModel : ViewModel() {
    private val _state = MutableStateFlow(Counterstate())
    val state = _state.asStateFlow()

    fun increment() {
        _state.update { currentState ->
            val newCount: Int = currentState.count + 1
            currentState.copy(
                count = newCount,
                history = currentState.history + "Incremented by $newCount"
            )
        }
    }

    fun decrement() {
        _state.update { currentState ->
            val newState: Int = currentState.count - 1
            currentState.copy(
                count = newState,
                history = currentState.history + "Decremented by $newState
            )
        }
    }

    fun reset() {
        _state.update { currentState ->
            if (currentState.count == 0) return@update currentState
            currentState.copy(
                count = 0,
                history = currentState.history + "Reset from ${currentState.count} to 0"
            )
        }
    }
}