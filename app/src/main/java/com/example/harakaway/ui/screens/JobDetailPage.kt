package com.example.harakaway.ui.screens

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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.harakaway.R
import com.example.harakaway.ui.components.IconButtonComponent

@Composable

fun JobDetailPage(innerPadding: PaddingValues, navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    )
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            IconButtonComponent(
                onClick = {},
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "back button"
            )
            Text(
                text = "Job Detail",
                fontSize = 22.sp,
                modifier = Modifier.padding(vertical = 10.dp)
            )
         IconButtonComponent(
             onClick = {},
             imageVector = Icons.Outlined.FavoriteBorder,
             contentDescription = "favourite"
         )
        }
        Column {
            Card(
                colors = CardColors(
                    containerColor = MaterialTheme.colorScheme.inverseOnSurface,
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
                            .fillMaxWidth(),
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
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Spotify",
                        color = Color.LightGray,
                        fontSize = 22.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Product Designer",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(8.dp))

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
                            fontSize = 14.sp,
                            modifier = Modifier
                                .padding(6.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Card {
                        Text(
                            text = "Remote",
                            fontWeight = FontWeight.Light,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .padding(6.dp)
                        )
                    }
                }

            }
        }
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                Card(
                    modifier = Modifier.clip(CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "person",
                        modifier = Modifier
                            .padding(20.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(horizontal = 14.dp))
                Card(
                    modifier = Modifier.clip(CircleShape)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.basket),
                        contentDescription = "basket",
                        modifier = Modifier
                            .padding(20.dp)
                            .size(25.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(horizontal = 14.dp))

                Card(
                    modifier = Modifier.clip(CircleShape)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.wallet),
                        contentDescription = "basket",
                        modifier = Modifier
                            .padding(20.dp)
                            .size(25.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(horizontal = 14.dp))

                Card(
                    modifier = Modifier.clip(CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = "person",
                        modifier = Modifier
                            .padding(20.dp)
                    )
                }


            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(horizontal = 2.dp, vertical = 4.dp)
            ){
                Text(
                    text = "Position",
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.padding(horizontal = 16.dp))
                Text(
                    text = "Job Type",
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.padding(horizontal = 16.dp))

                Text(
                    text = "Salary",
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.padding(horizontal = 16.dp))

                Text(
                    text = "Location",
                    fontWeight = FontWeight.Light
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(horizontal = 2.dp, vertical = 4.dp)
            ){
                Text(
                    text = "Senior",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.padding(horizontal = 16.dp))
                Text(
                    text = "Remote",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp

                )
                Spacer(modifier = Modifier.padding(horizontal = 16.dp))

                Text(
                    text = "$2k-$5k",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp

                )
                Spacer(modifier = Modifier.padding(horizontal = 16.dp))

                Text(
                    text = "Canada",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp

                )
            }
            Spacer(modifier = Modifier.padding(vertical = 14.dp))
            Column{
                Row{
                    Card( modifier = Modifier.clickable{}){
                        Text(
                            text = "Description",
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                    Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                    Card(modifier = Modifier.clickable{}){
                        Text(
                            text = "Company",
                            modifier = Modifier.padding(12.dp)

                        )
                    }
                    Spacer(modifier = Modifier.padding(horizontal = 4.dp))

                    Card(modifier = Modifier.clickable{}){
                        Text(
                            text = "Requirements",
                            modifier = Modifier.padding(12.dp)

                        )
                    }
                }
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                Row{
                    Card{
                        Text(
                            text = "About The Opportunity",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(vertical = 2.dp,horizontal = 8.dp)

                        )
                        Text(
                            text = stringResource(R.string.dummy_text),
                            color = Color.LightGray,
                            fontSize = 14.sp,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
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
                         .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(
                        text = "Apply Now",
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 16.dp))
                   IconButtonComponent(
                       onClick = {},
                       imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                       contentDescription = "apply",
                   )
                }
            }
        }

    }
}