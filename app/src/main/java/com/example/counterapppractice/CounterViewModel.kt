package com.example.counterapppractice

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