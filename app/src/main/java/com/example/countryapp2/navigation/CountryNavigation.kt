package com.example.countryapp2.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.countryapp2.navigation.CountryScreens
import com.example.countryapp2.screens.HomeScreen
import com.example.movieapp.screens.details.InfoScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryAppBar(
    currentScreen: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier
) {
    TopAppBar(
        title = { Text("Country Info App")},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondary
        ),
        modifier = modifier,
        navigationIcon = {
            if(canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = null
                    )
                }
            }
        }
    )
}
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CountryNavigation() {
    val navController = rememberNavController()

    val canNavigateBack = navController.currentBackStackEntry != null
    Scaffold(
        topBar = {
            CountryAppBar(
                currentScreen = "Country App",
                canNavigateBack = true,
                navigateUp = {navController.navigateUp()},
                modifier = Modifier
            )
        }
    ) {innerPadding ->
        NavHost(navController = navController,
            startDestination = CountryScreens.HomeScreen.name, modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)) {
            composable(CountryScreens.HomeScreen.name){
                HomeScreen(navController = navController)
            }
            composable(CountryScreens.InfoScreen.name+"/{country}",
                arguments = listOf(navArgument(name="country") {type=NavType.StringType})) {
                    backStackEntry ->
                InfoScreen(navController=navController,
                    backStackEntry.arguments?.getString("country"))
            }
        }
    }
}