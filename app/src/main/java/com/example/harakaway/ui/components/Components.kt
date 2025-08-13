package com.example.harakaway.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil3.compose.AsyncImage
import com.example.harakaway.ui.screens.applied.AppliedJobsPage
import com.example.harakaway.ui.screens.home.HomePage
import com.example.harakaway.ui.screens.JobDetailPage
import com.example.harakaway.ui.screens.Routes
import com.example.harakaway.ui.screens.admin.AdminForm

// navigation
@Composable
fun Navigation(navController: NavHostController, innerPaddingValues: PaddingValues) {

    NavHost(
        navController = navController,
        startDestination = Routes.Home.name,
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
        composable(route = Routes.AdminForm.name){
            AdminForm(
                navController = navController,
                innerPadding = innerPaddingValues,
                modifier = Modifier
            )
        }
        }
}

@Composable
fun IconButtonComponent(
    onClick: () -> Unit,
    imageVector: ImageVector,
    contentDescription: String
){
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surfaceContainerHigh)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
        )
    }
}

@Composable
fun CardWithImage(image: Int, contentDescription: String){
   Card(
       colors = CardColors(
           containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
           contentColor = Color.LightGray,
           disabledContainerColor = Color.DarkGray,
           disabledContentColor = Color.DarkGray,
       ),
       modifier = Modifier.padding(2.dp)
   ) {
       AsyncImage(
           model = image,
           contentDescription = contentDescription,
           contentScale = ContentScale.Crop,
           modifier = Modifier
               .size(64.dp)
               .padding(4.dp)
               .clip(CircleShape)
       )
   }
}

