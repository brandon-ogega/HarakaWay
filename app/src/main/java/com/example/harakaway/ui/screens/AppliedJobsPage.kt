package com.example.harakaway.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.harakaway.R

@Composable
fun AppliedJobsPage(navController: NavHostController) {
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
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp, horizontal = 16.dp)
        ){
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
                    text = "See jobs that you applied here.",
                    color = Color.LightGray
                )
            }
        }
    }
}