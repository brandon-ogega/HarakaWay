package com.example.harakaway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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

        WindowCompat.setDecorFitsSystemWindows(window, false)

        WindowInsetsControllerCompat(window,window.decorView).apply {
            isAppearanceLightStatusBars = false
            isAppearanceLightNavigationBars = false
        }

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
                var barState by rememberSaveable {
                    mutableStateOf(false)
                }
                val navController: NavHostController = rememberNavController()

                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStackEntry?.destination?.route
               barState = when(currentRoute){
                   Routes.Home.name -> {
                        true
                    }

                    else -> {
                        false
                    }
                }
                Scaffold(

                        floatingActionButton = {
                            if (barState){
                            IconButton(
                                colors = IconButtonColors(
                                    containerColor = Color.Blue,
                                    contentColor = Color.White,
                                    disabledContainerColor = Color.Gray,
                                    disabledContentColor = Color.DarkGray
                                ),
                                onClick = {navController.navigate(Routes.AdminForm.name)}
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Add,
                                    contentDescription = "Button of Adding New Jobs"
                                )
                            }
                        }else{}
                    },
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
                            .fillMaxSize()
                    ) {
                        Navigation(navController, innerPadding)
                    }
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