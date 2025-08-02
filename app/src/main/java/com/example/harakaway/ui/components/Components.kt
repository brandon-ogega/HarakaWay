package com.example.harakaway.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.harakaway.ui.screens.AppliedJobsPage
import com.example.harakaway.ui.screens.HomePage
import com.example.harakaway.ui.screens.JobDetailPage
import com.example.harakaway.ui.screens.Routes

// navigation
@Composable
fun Navigation(navController: NavHostController, innerPaddingValues: PaddingValues) {

    NavHost(
        navController = navController,
        startDestination = Routes.AppliedJobPage.name,
    ) {
        composable(route = Routes.Home.name) {
            HomePage(
                navController = navController,
                innerPadding = innerPaddingValues
            )
        }

        composable(route = Routes.AppliedJobPage.name){
            AppliedJobsPage(
                navController = navController,
                innerPadding = innerPaddingValues
            )
        }
        composable(route = Routes.JobDetailPage.name){
            JobDetailPage(
                navController = navController,
                innerPadding = innerPaddingValues
            )
        }
    }
}

