package com.example.harakaway.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.harakaway.R

@Composable

fun HomePage(innerPadding: PaddingValues,navController: NavHostController) {
    val searchInput: MutableState<String> = remember{
        mutableStateOf("")
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        AsyncImage(
            model = R.drawable.bg2,
            contentDescription = "maps",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp, horizontal = 16.dp)
        ) {
            Row{
                Text(text = "Hello, \nAlexander!",
                    fontSize = 32.sp,
                    lineHeight = 40.sp,
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
                    .padding(vertical = 0.5.dp,horizontal = 16.dp)
            ){
                Text(
                    text = "Wish you a good day.",
                    color = Color.LightGray
                )
            }
        }
       Row(
           horizontalArrangement = Arrangement.Center,
           modifier = Modifier
               .fillMaxWidth()
               .padding(8.dp)
       ){
           TextField(
               value = searchInput.value,
               placeholder = { Text(text = "Search for job title", color = Color.LightGray)},
               leadingIcon = {
                   Icon(
                       imageVector = Icons.Filled.Search,
                       contentDescription = "search job",
                       tint = Color.DarkGray
                   )
               },
               trailingIcon = {
                   Icon(
                       painter = painterResource(R.drawable.filter),
                       contentDescription = "filter",
                       tint = Color.DarkGray
                   )
               },
               colors = TextFieldDefaults.colors(
                   focusedContainerColor = Color.DarkGray,
                   unfocusedContainerColor = Color.DarkGray ,
                   errorContainerColor = Color.Red,
                   focusedIndicatorColor = Color.Transparent,
                   unfocusedIndicatorColor = Color.Transparent,
               ),
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(vertical = 8.dp, horizontal = 8.dp),
               shape = RoundedCornerShape(12.dp),
               onValueChange = { newValue ->
                   searchInput.value = newValue
               }
           )
       }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ){
            Text(
                text = "Recent Jobs",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
            Text(
                text = "View all",
                fontWeight = FontWeight.Light,
                fontSize = 16.sp,
            )
        }
       Column{
           Card(
               colors = CardColors(
                   containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
                   contentColor = Color.LightGray,
                   disabledContainerColor = Color.DarkGray,
                   disabledContentColor = Color.DarkGray,
               ),
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(8.dp)
                   .clip(RoundedCornerShape(32.dp)),
               elevation = CardDefaults.cardElevation(8.dp),
           ){
               Column(
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(16.dp)
               ){
                   Row(
                       modifier = Modifier
                           .fillMaxWidth(),
                       horizontalArrangement = Arrangement.Center,
                       verticalAlignment = Alignment.CenterVertically,
                   ) {
                       AsyncImage(
                           model = R.drawable.spotify,
                           contentDescription = "icon",
                           modifier = Modifier
                               .size(150.dp)
                       )
                   }
                   Spacer(modifier = Modifier.height(12.dp))
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
               ){
                   Card{
                       Text(
                           text = "Fulltime",
                           fontWeight = FontWeight.Light,
                           fontSize = 12.sp,
                           modifier = Modifier
                               .padding(2.dp)
                       )
                   }
                   Spacer(modifier = Modifier.width(8.dp))
                   Card{
                       Text(
                           text = "Remote",
                           fontWeight = FontWeight.Light,
                           fontSize = 12.sp,
                           modifier = Modifier
                               .padding(2.dp)
                       )
                   }
               }
               Row(
                   horizontalArrangement = Arrangement.Center,
                   verticalAlignment = Alignment.CenterVertically,
               ){
                   Button(
                       colors = ButtonColors(
                           containerColor = Color.Yellow,
                           contentColor = Color.Black,
                           disabledContainerColor = Color.Gray,
                           disabledContentColor = Color.DarkGray
                       ),
                       onClick = {},
                       modifier = Modifier
                           .padding(horizontal = 128.dp)
                   ){
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
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ){
            Text(
                text = "Category",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
            Text(
                text = "View all",
                fontWeight = FontWeight.Light,
                fontSize = 16.sp,
            )
        }

        val configuration = LocalConfiguration.current
        val screenHeight = configuration.screenHeightDp.dp
        val screenWidth = configuration.screenWidthDp.dp

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight *1/3)
                .padding(16.dp)
        ) {
//       colum categories
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(screenWidth *2/3)
             ){
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                   Column(
                       horizontalAlignment = Alignment.CenterHorizontally,
                       verticalArrangement = Arrangement.Center,
                       modifier = Modifier
                           .fillMaxWidth()
                   ){
                       Text(
                           text = "Recommended"  ,
                           fontWeight = FontWeight.Bold,
                           textAlign = TextAlign.Center,
                           modifier = Modifier
                               .fillMaxWidth()
                       )
                       Text(
                           text =   "244+ Jobs",
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
//                            .fillMaxHeight()
                    ){
                        Text(
                            text = "Recommended"  ,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Text(
                            text =   "244+ Jobs",
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
                    .width(screenWidth * 1/3))
            {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .height(screenHeight*1/10)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ){
                        Text(
                            text = "Recommended"  ,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Text(
                            text =   "244+ Jobs",
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
    }
}