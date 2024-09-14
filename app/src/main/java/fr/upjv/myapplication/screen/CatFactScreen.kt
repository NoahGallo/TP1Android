package fr.upjv.myapplication.screen

import CatFactViewModel
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
fun CatFactScreen(navController: NavController) {
    val viewModel: CatFactViewModel = viewModel()
    val list = viewModel.catFacts.collectAsState(emptyList()).value

    LazyColumn(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(list) { item ->
            Text(text = "Cat Fact: ${item.fact}")
        }
        item {
            Button(
                content = { Text("Add") },
                onClick = { viewModel.insertNewCatFact() }
            )
            Button(
                content = { Text("Delete") },
                onClick = { viewModel.deleteAllCatFacts() }
            )
        }
    }
}
