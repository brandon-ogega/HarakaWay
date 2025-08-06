package com.example.harakaway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.example.harakaway.data.models.BottomNavBarItem
import com.example.harakaway.ui.components.Navigation
import com.example.harakaway.ui.screens.Routes
import com.example.harakaway.ui.theme.HarakaWayTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashscreen = installSplashScreen()
        var keepSplashScreen = true
        super.onCreate(savedInstanceState)
        splashscreen.setKeepOnScreenCondition { keepSplashScreen }
        lifecycleScope.launch {
            delay(4000)
            keepSplashScreen = false
        }
        enableEdgeToEdge()
        setContent {
            HarakaWayTheme {
                val navigationItems = listOf(
                    BottomNavBarItem(
                        title = Routes.Home.name,
                        iconCustomSelected = R.drawable.home,
                        iconCustomNotSelected = R.drawable.home,
                    ),
                    BottomNavBarItem(
                        title = Routes.AppliedJobPage.name,
                        iconCustomSelected = R.drawable.basket,
                        iconCustomNotSelected = R.drawable.basket,
                    ),
                    BottomNavBarItem(
                        title = Routes.JobDetailPage.name,
                        iconCustomSelected = R.drawable.contract,
                        iconCustomNotSelected = R.drawable.contract,
                    ),
                )
                var selectedItem by rememberSaveable {
                    mutableIntStateOf(0)
                }
                val navController: NavHostController = rememberNavController()

                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStackEntry?.destination?.route

                Scaffold(
                    bottomBar = {
                        if (currentRoute != "HomePage") {
                            NavigationBar(
                                containerColor = MaterialTheme.colorScheme.inverseOnSurface
                            ) {
                                navigationItems.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = selectedItem == index,
                                        colors = NavigationBarItemColors(
                                            selectedIconColor = Color.Gray,
                                            selectedTextColor = Color.Gray,
                                            selectedIndicatorColor = Color.Yellow,
                                            unselectedIconColor = Color.DarkGray,
                                            unselectedTextColor = Color.DarkGray,
                                            disabledIconColor = Color.Gray,
                                            disabledTextColor = Color.Gray,
                                        ),
                                        onClick = {
                                            selectedItem = index
                                            navController.navigate(route = item.title)
                                            println("Navigations....")
                                        },
                                        icon ={
                                            if (selectedItem == index) {
                                                item.iconCustomSelected?.let {
                                                    Column(verticalArrangement = Arrangement.SpaceEvenly) {
                                                        Icon(
                                                            painter = painterResource(it),
                                                            contentDescription = "icon of ${item.title}",
                                                            modifier = Modifier.size(24.dp),
                                                            tint = Color.Black
                                                        )
 
                                                    }
                                                }
                                            } else {
                                                item.iconCustomNotSelected?.let {
                                                    Icon(
                                                        painter = painterResource(it),
                                                        contentDescription = "icon of ${item.title}",
                                                        modifier = Modifier.size(24.dp),
                                                        tint = Color.LightGray
                                                    )
                                                }
                                            }
                                        },
                                        label = { item.title }
                                    )
                                }
                            }
                        }
                    },
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.inverseOnSurface)
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        Navigation(navController, innerPadding)                    }
                    }
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        HarakaWayTheme {

            val navController: NavHostController = rememberNavController()
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Navigation(navController, innerPadding)
            }

    }
}