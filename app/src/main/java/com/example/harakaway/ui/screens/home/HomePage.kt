package com.example.harakaway.ui.screens.home

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.harakaway.R
import com.example.harakaway.ui.screens.Routes
import com.example.harakaway.ui.screens.home.HomeViewModel
import com.example.harakaway.ui.theme.amber
import com.example.harakaway.ui.theme.orange
import com.example.harakaway.ui.theme.sportsGreen

@Composable

fun HomePage(innerPadding: PaddingValues, navController: NavHostController,viewModel: HomeViewModel= viewModel() ) {
    val searchInput = viewModel.searchInput.value
    Scaffold(
//        floatingActionButton = {
//            IconButton(
//                colors = IconButtonColors(
//                    containerColor = Color.Blue,
//                    contentColor = Color.White,
//                    disabledContainerColor = Color.Gray,
//                    disabledContentColor = Color.DarkGray
//                ),
//                onClick = {navController.navigate(Routes.AdminForm.name)}
//            ) {
//                Icon(
//                    imageVector = Icons.Filled.Add,
//                    contentDescription = "Button of Adding New Jobs"
//                )
//            }
//        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {

            Spacer(modifier = Modifier.height(30.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp,vertical = 14.dp)
            ) {
                Column {
                    Text(
                        text = "Hello, ",
                        fontSize = 32.sp,
                    )
                    Text(
                        text = "Alexander!",
                        fontSize = 32.sp,
                    )


                }
                Column {
                    AsyncImage(
                        model = R.drawable.super_mario,
                        contentDescription = "Profile image of user - super mario",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .border(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(Color.Red, Color.Blue, Color.Green),
                                    startX = 0.0f,
                                    endX = 500.0f,
                                    tileMode = TileMode.Repeated
                                ),
                                width = 4.dp,
                                shape = RoundedCornerShape(32.dp)
                            )
                    )
                }
            }
            Column {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Wish you a good day.",
                        color = Color.LightGray
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                TextField(
                    value = searchInput,
                    onValueChange = {viewModel.onSearchInputChange(it)},
                    placeholder = { Text(text = "Search for job title", color = Color.LightGray) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "search job",
                            tint = Color.LightGray
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                        unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                        errorContainerColor = Color.Red,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 8.dp),
                    shape = RoundedCornerShape(12.dp),
                )

                Icon(
                    painter = painterResource(R.drawable.filter),
                    contentDescription = "filter",
                    tint = Color.White
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Recent Jobs",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
                Text(
                    text = "View all",
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    modifier = Modifier.clickable {navController.navigate(Routes.AppliedJobPage.name)}
                )
            }
            Column {
                Card(
                    colors = CardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                        contentColor = Color.LightGray,
                        disabledContainerColor = Color.DarkGray,
                        disabledContentColor = Color.DarkGray,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    elevation = CardDefaults.cardElevation(8.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Card {
                                AsyncImage(
                                    model = R.drawable.mze,
                                    contentDescription = "icon",
                                    modifier = Modifier
                                        .size(75.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Spotify",
                            fontSize = 16.sp,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Text(
                            text = "Product Designer",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Card {
                            Text(
                                text = "Fulltime",
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .padding(6.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Card {
                            Text(
                                text = "Remote",
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .padding(6.dp)
                            )
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Button(
                            colors = ButtonColors(
                                containerColor = Color.Yellow,
                                contentColor = Color.Black,
                                disabledContainerColor = Color.Gray,
                                disabledContentColor = Color.DarkGray
                            ),
                            onClick = {
                                navController.navigate(Routes.JobDetailPage.name)
                            },
                            modifier = Modifier
                                .padding(horizontal = 128.dp)
                        ) {
                            Text(
                                text = "Browse",
                            )
                        }
                    }
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Category",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
                Text(
                    text = "View all",
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    modifier = Modifier.clickable {navController.navigate(Routes.AppliedJobPage.name)}
                )
            }

            val configuration = LocalConfiguration.current
            val screenHeight = configuration.screenHeightDp.dp
            val screenWidth = configuration.screenWidthDp.dp

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(screenHeight * 1 / 3)
                    .padding(horizontal = 16.dp)
            ) {
//       colum categories
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(screenWidth * 2 / 3)
                ) {
                    Card(
                        colors = CardColors(
                            containerColor = sportsGreen,
                            contentColor = Color.LightGray,
                            disabledContainerColor = Color.DarkGray,
                            disabledContentColor = Color.DarkGray,
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(40.dp)
                        ) {
                            Text(
                                text = "Recommended",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                            Text(
                                text = "244+ Jobs",
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(vertical = 4.dp))
                    Card(
                        colors = CardColors(
                            containerColor = amber,
                            contentColor = Color.LightGray,
                            disabledContainerColor = Color.DarkGray,
                            disabledContentColor = Color.DarkGray,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(40.dp)
                        ) {
                            Text(
                                text = "Recently Added",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                            Text(
                                text = "250+ Jobs",
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                    }

                }
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(screenWidth * 1 / 3)
                )
                {
                    Card(
                        colors = CardColors(
                            containerColor = orange,
                            contentColor = Color.LightGray,
                            disabledContainerColor = Color.DarkGray,
                            disabledContentColor = Color.DarkGray,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .height(screenHeight * 1 / 10)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                        ) {
                            Text(
                                text = "Nearby",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                            Text(
                                text = "231+ Jobs",
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                    }
                }

            }
            Spacer(modifier = Modifier.height(100.dp))

        }
    }
}