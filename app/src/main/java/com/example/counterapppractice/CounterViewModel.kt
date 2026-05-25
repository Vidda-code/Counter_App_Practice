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
            val newCount:Int = currentState.count + 1
            currentState.copy(
                count = newCount,
                history = currentState.history + "Incremented by $newCount"
            )
        }
    }
}