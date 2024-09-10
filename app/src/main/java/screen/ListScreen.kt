package screen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import model.ItemUi

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Car List", color = Color.White) }, // Set title color to white
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF4F4F4F)), // Nardo grey app bar
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            )
        },
        modifier = Modifier.fillMaxSize() // Ensures the scaffold takes full screen size
    ) { innerPadding ->
        MyScreen(innerPadding) // Pass innerPadding to MyScreen
    }
}

private fun populateMyList(): List<ItemUi.MyCarObject> {
    return listOf(
        ItemUi.MyCarObject(brandName = "Audi", modelName = "RS3", power = "400 HP"),
        ItemUi.MyCarObject(brandName = "Audi", modelName = "RS6", power = "591 HP"),
        ItemUi.MyCarObject(brandName = "BMW", modelName = "M4", power = "503 HP"),
        ItemUi.MyCarObject(brandName = "BMW", modelName = "M3", power = "473 HP"),
        ItemUi.MyCarObject(brandName = "Mercedes", modelName = "C63 AMG", power = "503 HP"),
        ItemUi.MyCarObject(brandName = "Mercedes", modelName = "E63 AMG", power = "603 HP"),
        ItemUi.MyCarObject(brandName = "Porsche", modelName = "911 Turbo S", power = "640 HP"),
        ItemUi.MyCarObject(brandName = "Porsche", modelName = "718 Cayman GT4", power = "414 HP"),
        ItemUi.MyCarObject(brandName = "Nissan", modelName = "GT-R", power = "565 HP"),
        ItemUi.MyCarObject(brandName = "Ford", modelName = "Mustang Shelby GT500", power = "760 HP"),
        ItemUi.MyCarObject(brandName = "Chevrolet", modelName = "Camaro ZL1", power = "650 HP"),
        ItemUi.MyCarObject(brandName = "Lamborghini", modelName = "Huracán", power = "631 HP"),
        ItemUi.MyCarObject(brandName = "Ferrari", modelName = "488 Pista", power = "710 HP"),
        ItemUi.MyCarObject(brandName = "McLaren", modelName = "720S", power = "710 HP"),
        ItemUi.MyCarObject(brandName = "Aston Martin", modelName = "Vantage", power = "503 HP"),
        ItemUi.MyCarObject(brandName = "Dodge", modelName = "Charger SRT Hellcat", power = "707 HP"),
        ItemUi.MyCarObject(brandName = "Hyundai", modelName = "i30 N", power = "276 HP"),
        ItemUi.MyCarObject(brandName = "Hyundai", modelName = "Kona N", power = "276 HP"),
        ItemUi.MyCarObject(brandName = "Hyundai", modelName = "i20 N", power = "204 HP")
    )
}

@Composable
private fun MyScreen(innerPadding: PaddingValues) {
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

            // Updated LazyColumn
            val listOfResult: MutableList<ItemUi> = mutableListOf()

            populateMyList()
                .groupBy { car -> car.brandName }
                .forEach {
                    listOfResult.add(
                        ItemUi.Header(title = it.key)
                    )
                    listOfResult.addAll(it.value)
                }

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

                        is ItemUi.MyCarObject -> Column(
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
