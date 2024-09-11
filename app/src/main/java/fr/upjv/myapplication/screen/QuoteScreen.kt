package fr.upjv.myapplication.screen

import ChuckNorrisViewModel
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun QuoteScreen(navController: NavController) {
    val viewModel: ChuckNorrisViewModel = viewModel()
    val list = viewModel.quote.collectAsState(emptyList()).value


    LazyColumn(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(list) { item ->
            Text(text = "Name = ${item.quote}")
        }
        item {
            Button(
                content = { Text("Add") },
                onClick = { viewModel.insertNewQuote() }
            )
            Button(
                content = { Text("Delete") },
                onClick = { viewModel.deleteAllQuote() }
            )
        }
    }
}
