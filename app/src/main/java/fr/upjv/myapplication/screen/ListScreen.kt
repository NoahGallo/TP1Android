package fr.upjv.myapplication.screen

import AndroidVersionViewModel
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import fr.upjv.myapplication.model.ItemUi

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavController,
) {
    val viewModel: AndroidVersionViewModel = viewModel()
    val listOfResult = viewModel.androidVersionList.collectAsState(initial = emptyList()).value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("List Screen") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        bottomBar = {
            Row {
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.insertAndroidVersion() }
                ) {
                    Text("Add")
                }
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.deleteAllAndroidVersion() }
                ) {
                    Text("Delete")
                }
            }
        },
        modifier = Modifier.fillMaxSize() // Ensures the scaffold takes full screen size
    ) { innerPadding ->
        MyScreen(innerPadding, listOfResult, viewModel) // Pass innerPadding and list to MyScreen
    }
}

@Composable
private fun MyScreen(innerPadding: PaddingValues, listOfResult: List<ItemUi>, viewModel: AndroidVersionViewModel) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding), // Apply inner padding from Scaffold
        color = Color(0xFF4F4F4F) // Full screen nardo grey background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), // Ensure no unnecessary padding and white space
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header with line above and below
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.White) // White line above the header
                )
                Text(
                    text = "Welcome to the Car List!",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.White) // White line below the header
                )
            }

            // Image loading
            val painter = rememberAsyncImagePainter(
                ImageRequest
                    .Builder(LocalContext.current)
                    .data("https://upload.wikimedia.org/wikipedia/de/thumb/c/c0/Scuderia_Ferrari_Logo.svg/1536px-Scuderia_Ferrari_Logo.svg.png")
                    .build()
            )
            Box(
                modifier = Modifier
                    .size(128.dp) // Maintain original size
                    .border(1.dp, Color.White), // Optional: add border to visualize edges
                contentAlignment = Alignment.Center // Center the image within the box
            ) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Inside, // Ensure the entire image is visible
                    modifier = Modifier.fillMaxSize() // Ensure the image fills the container
                )
            }

            // Display the car list from the ViewModel
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth() // Fills width, no extra space
                    .weight(1f), // Take remaining space
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(listOfResult) { eachItem ->
                    when (eachItem) {
                        is ItemUi.Header -> Text(
                            text = eachItem.title,
                            style = MaterialTheme.typography.displaySmall,
                            color = Color(0xFFD1D1D1) // Light grey text for headers
                        )

                        is ItemUi.Item -> Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(2.dp, Color(0xFFD1D1D1), shape = RectangleShape) // Border for each car item
                                .padding(8.dp) // Padding within the border
                        ) {
                            Text(
                                text = "Brand: ${eachItem.brandName}",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color(0xFFD1D1D1)
                            )
                            Text(
                                text = "Model: ${eachItem.modelName}",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color(0xFFD1D1D1)
                            )
                            Text(
                                text = "Power: ${eachItem.power}",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color(0xFFD1D1D1)
                            )
                        }
                    }
                }
            }

            // Footer with line above
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.White) // White line above the footer
                )
                Text(
                    text = "Developed by Noah Gallo. All rights reserved.",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White,
                    modifier = Modifier.padding(top = 16.dp) // Padding above the footer
                )
            }
        }
    }
}
