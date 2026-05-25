package com.example.counterapppractice

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

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
}