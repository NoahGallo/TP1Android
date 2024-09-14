package fr.upjv.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.upjv.myapplication.screen.ListScreen
import fr.upjv.myapplication.screen.MainScreen
import fr.upjv.myapplication.screen.QuoteScreen
import fr.upjv.myapplication.screen.CatFactScreen

object NavigationPath {
    const val MAIN_SCREEN = "main_screen"
    const val LIST_SCREEN = "list_screen"
    const val QUOTE_SCREEN = "quote_screen"
    const val CAT_FACT_SCREEN = "cat_fact_screen" // New path for Cat Fact Screen
}

fun NavGraphBuilder.addMainScreenNav(
    onButtonClick: () -> Unit,
    onButton2Click: () -> Unit,
    onButton3Click: () -> Unit // New button for Cat Fact navigation
) {
    composable(
        route = NavigationPath.MAIN_SCREEN
    ) {
        MainScreen(
            onButtonClick = {
                onButtonClick()
            },
            onButton2Click = {
                onButton2Click()
            },
            onButton3Click = { // Handle the new button click
                onButton3Click()
            }
        )
    }
}

fun NavGraphBuilder.addListScreenNavigation(navController: NavController) {
    composable(
        route = NavigationPath.LIST_SCREEN,
    ) {
        ListScreen(navController)
    }
}

fun NavGraphBuilder.addQuoteScreenNavigation(navController: NavController) {
    composable(
        route = NavigationPath.QUOTE_SCREEN,
    ) {
        QuoteScreen(navController)
    }
}

fun NavGraphBuilder.addCatFactScreenNavigation(navController: NavController) {
    composable(
        route = NavigationPath.CAT_FACT_SCREEN,
    ) {
        CatFactScreen(navController)
    }
}

@Composable
fun HomeNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = NavigationPath.MAIN_SCREEN,
    ) {
        addMainScreenNav(
            onButtonClick = { navController.navigate(NavigationPath.LIST_SCREEN) },
            onButton2Click = { navController.navigate(NavigationPath.QUOTE_SCREEN) },
            onButton3Click = { navController.navigate(NavigationPath.CAT_FACT_SCREEN) } // New button navigation
        )
        addListScreenNavigation(navController = navController)
        addQuoteScreenNavigation(navController = navController)
        addCatFactScreenNavigation(navController = navController) // New Cat Fact screen navigation
    }
}
