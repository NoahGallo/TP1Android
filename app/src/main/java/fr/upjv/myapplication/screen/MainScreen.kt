package fr.upjv.myapplication.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
    onButtonClick: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0xFF4F4F4F) // Nardo Grey background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center // Centers vertically
        ) {
            Text(
                text = "Noah Gallo",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White // White text for contrast
            )

            Spacer(modifier = Modifier.height(16.dp)) // Space between text and button

            Button(
                onClick = { onButtonClick() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White) // White button
            ) {
                Text(
                    text = "Go to List Screen",
                    color = Color(0xFF4F4F4F) // Nardo Grey text
                )
            }
        }
    }
}
