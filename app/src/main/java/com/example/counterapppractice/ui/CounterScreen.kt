package com.example.counterapppractice.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ManageHistory
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CounterScreen(
    count: Int,
    label: String,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onReset: () -> Unit,
    onHistory: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(vertical = 80.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Label
        Box(
            Modifier
                .clip(shape = CircleShape)
                .background(color = Color(0xFF89CEFF))
                .padding(12.dp)
        ) {
            Text(
                text = label,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 16.sp
            )
        }

        // Count display
        Card(
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(32.dp)
                    .size(300.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xFFE2E8F0),
                        shape = CircleShape
                    )
            ) {
                Text(
                    text = count.toString(),
                    fontSize = 135.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                )
            }
        }

        // Increment and decrement buttons
        Row {
            // Remove Button
            Button(
                onClick = onDecrement,
                shape = CircleShape,
                modifier = Modifier.size(80.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3323CC)
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Remove,
                    contentDescription = "Subtract count by 1",
                )
            }

            Spacer(Modifier.width(18.dp))

            // Add Button
            Button(
                onClick = onIncrement,
                shape = CircleShape,
                modifier = Modifier.size(80.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3323CC)
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Count by 1"
                )
            }
        }

        // Reset Button
        OutlinedButton(
            onClick = onReset,
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Gray
            )
        ) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Reset counter",
                modifier = Modifier.size(24.dp)
            )
            Spacer(Modifier.width(ButtonDefaults.IconSpacing))
            Text(
                text = "Reset Counter",
                fontSize = 18.sp
            )
        }

        //History Button
        ExtendedFloatingActionButton(
            onClick = onHistory,
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ManageHistory,
                contentDescription = "History Icon"
            )
            Spacer(Modifier.width(ButtonDefaults.IconSpacing))
            Text(text = "History")
        }
    }
}