package com.example.harakaway.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.harakaway.R

@Composable
fun AppliedJobsPage(innerPadding: PaddingValues, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Row {
                    Text(
                        text = "Applied, \nJobs",
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

            Row(
                modifier = Modifier
                    .padding(vertical = 0.5.dp, horizontal = 16.dp)
            ) {
                Text(
                    text = "See your applied jobs here.",
                    color = Color.LightGray
                )
            }
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Card(
                    colors = CardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                        contentColor = Color.LightGray,
                        disabledContainerColor = Color.DarkGray,
                        disabledContentColor = Color.DarkGray,
                    ),
                    modifier = Modifier
                        .padding(12.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    elevation = CardDefaults.cardElevation(4.dp),
                ) {
                    Row(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                       Card {
                           AsyncImage(
                               model = R.drawable.spotify,
                               contentDescription = "Icon",
                               contentScale = ContentScale.Crop,
                               modifier = Modifier
                                   .size(50.dp)
                           )
                       }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column() {
                            Text(
                                text = "Spotify",
                                fontWeight = FontWeight.ExtraLight,
                                fontSize = 18.sp


                            )
                            Text(
                                text = "Product Designer",
                                fontSize = 22.sp
                            )

                        }
                        Spacer(modifier = Modifier.width(65.dp))
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = "xx",
                            modifier = Modifier.clickable{}
                            )
                    }
                    Row(
                        modifier = Modifier.padding(vertical = 8.dp,horizontal = 16.dp)

                    ){
                        Card(
                            colors = CardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                                contentColor = Color.LightGray,
                                disabledContainerColor = Color.DarkGray,
                                disabledContentColor = Color.DarkGray,
                            )
                        ){
                            Text(
                                text = "Fulltime",
                                fontWeight = FontWeight.Light,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(6.dp)
                            )
                        }
                        Spacer(modifier = Modifier.padding(4.dp))
                        Card(
                            colors = CardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                                contentColor = Color.LightGray,
                                disabledContainerColor = Color.DarkGray,
                                disabledContentColor = Color.DarkGray,
                                )
                        ) {
                            Text(
                                text = "Remote",
                                fontWeight = FontWeight.Light,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(6.dp)
                            )
                        }
                    }
                    Row(){
                        Text(
                            text = "$2 - $5k/Month",
                            fontSize = 18.sp,
                            modifier = Modifier.padding(vertical = 8.dp,horizontal = 16.dp)
                        )
                    }
                    Column(){
                        Row(
                            modifier = Modifier.padding(horizontal = 14.dp)
                        ){
                            Icon(
                                imageVector = Icons.Outlined.LocationOn,
                                contentDescription = "icon",
                                modifier = Modifier
                                    .size(18.dp)
                            )
                            Text(
                                text = "USA, Canada",
                                modifier = Modifier.padding(horizontal = 1.5.dp)
                            )
                            Spacer(modifier = Modifier.padding(vertical = 32.dp,horizontal = 60.dp))
                            Card(
                                colors = CardColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                                    contentColor = Color.LightGray,
                                    disabledContainerColor = Color.DarkGray,
                                    disabledContentColor = Color.DarkGray,
                                )
                            ){
                                Text(
                                    text = "Accepted",
                                    color = Color.Green,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .padding(10.dp)
                                )
                            }
                        }
                    }
                }
            }
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Card(
                    colors = CardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                        contentColor = Color.LightGray,
                        disabledContainerColor = Color.DarkGray,
                        disabledContentColor = Color.DarkGray,
                    ),
                    modifier = Modifier
                        .padding(12.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    elevation = CardDefaults.cardElevation(4.dp),
                ) {
                    Row(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Card {
                            AsyncImage(
                                model = R.drawable.ic_launcher_foreground,
                                contentDescription = "Icon",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(50.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column() {
                            Text(
                                text = "Google",
                                fontWeight = FontWeight.ExtraLight,
                                fontSize = 18.sp


                            )
                            Text(
                                text = "Copy Writer",
                                fontSize = 22.sp
                            )

                        }
                        Spacer(modifier = Modifier.width(65.dp))
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = "xx",
                            modifier = Modifier.clickable{}
                        )
                    }
                    Row(
                        modifier = Modifier.padding(vertical = 8.dp,horizontal = 16.dp)

                    ){
                        Card(
                            colors = CardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                                contentColor = Color.LightGray,
                                disabledContainerColor = Color.DarkGray,
                                disabledContentColor = Color.DarkGray,
                            )
                        ){
                            Text(
                                text = "Fulltime",
                                fontWeight = FontWeight.Light,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(6.dp)
                            )
                        }
                        Spacer(modifier = Modifier.padding(4.dp))
                        Card(
                            colors = CardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                                contentColor = Color.LightGray,
                                disabledContainerColor = Color.DarkGray,
                                disabledContentColor = Color.DarkGray,
                            )
                        ) {
                            Text(
                                text = "Remote",
                                fontWeight = FontWeight.Light,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(6.dp)
                            )
                        }
                        Spacer(modifier = Modifier.padding(4.dp))
                        Card(
                            colors = CardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                                contentColor = Color.LightGray,
                                disabledContainerColor = Color.DarkGray,
                                disabledContentColor = Color.DarkGray,
                            )
                        ) {
                            Text(
                                text = "Anywhere",
                                fontWeight = FontWeight.Light,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(6.dp)
                            )
                        }
                    }
                    Row(){
                        Text(
                            text = "$3 - $6k/Month",
                            fontSize = 18.sp,
                            modifier = Modifier.padding(vertical = 8.dp,horizontal = 16.dp)
                        )
                    }
                    Column(){
                        Row(
                            modifier = Modifier.padding(horizontal = 14.dp)
                        ){
                            Icon(
                                imageVector = Icons.Outlined.LocationOn,
                                contentDescription = "icon",
                                modifier = Modifier
                                    .size(18.dp)
                            )
                            Text(
                                text = "UK,London",
                                modifier = Modifier.padding(horizontal = 1.5.dp)
                            )
                            Spacer(modifier = Modifier.padding(vertical = 32.dp,horizontal = 60.dp))
                            Card(
                                colors = CardColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                                    contentColor = Color.LightGray,
                                    disabledContainerColor = Color.DarkGray,
                                    disabledContentColor = Color.DarkGray,
                                )
                            ){
                                Text(
                                    text = "Rejected",
                                    color = Color.Red,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .padding(10.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}