package com.example.harakaway.ui.screens
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.horizontalScroll
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.runtime.Composable
//
//
//data class JobApplication(
//    val title: String,
//    val company: String,
//    val location: String,
//    val status: String,
//    val applyDate: String
//)
//
//@Composable
//fun AppliedJobsPage(innerPaddingValues: PaddingValues){
//    val allJobs = listOf(
//        JobApplication("Senior Android Developer", "TechNova Ltd.", "Remote", "Applied", "Jul 10, 2025"),
//        JobApplication("UI/UX Designer", "Designify", "Nairobi", "Accepted", "Jul 12, 2025"),
//        JobApplication("Data Analyst", "Insights Co.", "Hybrid", "Rejected", "Jul 15, 2025"),
//        JobApplication("Flutter Dev", "AppLab", "Remote", "Applied", "Jul 17, 2025")
//    )
//
//    var selectedFilter by remember { mutableStateOf("All") }
//    val filters = listOf("All", "Applied", "Accepted", "Rejected")
//    val scrollState = rememberScrollState()
//
//    val filteredJobs = when (selectedFilter) {
//        "Applied" -> allJobs.filter { it.status == "Applied" }
//        "Accepted" -> allJobs.filter { it.status == "Accepted" }
//        "Rejected" -> allJobs.filter { it.status == "Rejected" }
//        else -> allJobs
//    }
//
//// Filter tabs
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .horizontalScroll(scrollState)
//            .padding(vertical = 8.dp),
//        horizontalArrangement = Arrangement.spacedBy(12.dp)
//    ) {
//        filters.forEach { filter ->
//            val isSelected = filter == selectedFilter
//            val background = if (isSelected) MaterialTheme.colorScheme.primary else Color(0xFF2C2C2C)
//            val textColor = if (isSelected) Color.White else Color.Gray
//
//            Box(
//                modifier = Modifier
//                    .clip(RoundedCornerShape(20.dp))
//                    .background(background)
//                    .clickable { selectedFilter = filter }
//                    .padding(horizontal = 20.dp, vertical = 10.dp)
//            ) {
//                Text(
//                    text = filter,
//                    color = textColor,
//                    fontSize = 16.sp,
//                    style = MaterialTheme.typography.bodyMedium
//                )
//            }
//        }
//    }
//
//    Spacer(modifier = Modifier.height(16.dp))
//
//// Job cards list
//    LazyColumn(
//        verticalArrangement = Arrangement.spacedBy(12.dp),
//        modifier = Modifier.fillMaxSize()
//    ) {
//        items(filteredJobs) { job ->
//            Card(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(140.dp),
//                shape = RoundedCornerShape(16.dp),
//                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
//                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//            ) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(16.dp)
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .size(48.dp)
//                            .clip(CircleShape)
//                            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))
//                    )
//
//                    Spacer(modifier = Modifier.width(12.dp))
//
//                    Column(modifier = Modifier.weight(1f)) {
//                        Text(
//                            text = job.title,
//                            style = MaterialTheme.typography.titleMedium,
//                            color = MaterialTheme.colorScheme.onSurface,
//                            maxLines = 1,
//                            overflow = TextOverflow.Ellipsis
//                        )
//                        Text(
//                            text = job.company,
//                            style = MaterialTheme.typography.bodyMedium,
//                            color = MaterialTheme.colorScheme.onSurfaceVariant
//                        )
//                        Text(
//                            text = job.location,
//                            style = MaterialTheme.typography.bodySmall,
//                            color = MaterialTheme.colorScheme.onSurfaceVariant
//                        )
//
//                        Spacer(modifier = Modifier.height(8.dp))
//
//                        Row(
//                            verticalAlignment = Alignment.CenterVertically,
//                            horizontalArrangement = Arrangement.SpaceBetween,
//                            modifier = Modifier.fillMaxWidth()
//                        ) {
//                            val badgeColor = when (job.status) {
//                                "Applied" -> MaterialTheme.colorScheme.primary
//                                "Accepted" -> Color(0xFF00C853)
//                                "Rejected" -> Color(0xFFD32F2F)
//                                else -> Color.Gray
//                            }
//
//                            Box(
//                                modifier = Modifier
//                                    .background(badgeColor, shape = RoundedCornerShape(8.dp))
//                                    .padding(horizontal = 8.dp, vertical = 4.dp)
//                            ) {
//                                Text(
//                                    text = job.status,
//                                    color = Color.White,
//                                    style = MaterialTheme.typography.labelMedium
//                                )
//                            }
//
//                            Text(
//                                text = job.applyDate,
//                                color = MaterialTheme.colorScheme.onSurfaceVariant,
//                                style = MaterialTheme.typography.labelSmall
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    // Put this model outside the composable, or at the bottom of your file:
//
//}
////
//////import androidx.compose.foundation.background
//////import androidx.compose.foundation.border
//////import androidx.compose.foundation.clickable
//////import androidx.compose.foundation.layout.Arrangement
//////import androidx.compose.foundation.layout.Box
//////import androidx.compose.foundation.layout.Column
//////import androidx.compose.foundation.layout.PaddingValues
//////import androidx.compose.foundation.layout.Row
//////import androidx.compose.foundation.layout.fillMaxSize
//////import androidx.compose.foundation.layout.fillMaxWidth
//////import androidx.compose.foundation.layout.padding
//////import androidx.compose.foundation.layout.size
//////import androidx.compose.foundation.rememberScrollState
//////import androidx.compose.foundation.shape.CircleShape
//////import androidx.compose.foundation.shape.RoundedCornerShape
//////import androidx.compose.foundation.verticalScroll
//////import androidx.compose.material3.MaterialTheme
//////import androidx.compose.material3.Text
//////import androidx.compose.runtime.Composable
//////import androidx.compose.runtime.getValue
//////import androidx.compose.runtime.mutableStateOf
//////import androidx.compose.runtime.remember
//////import androidx.compose.runtime.setValue
//////import androidx.compose.ui.Alignment
//////import androidx.compose.ui.Modifier
//////import androidx.compose.ui.draw.clip
//////import androidx.compose.ui.graphics.Brush
//////import androidx.compose.ui.graphics.Color
//////import androidx.compose.ui.graphics.TileMode
//////import androidx.compose.ui.layout.ContentScale
//////import androidx.compose.ui.unit.dp
//////import androidx.compose.ui.unit.sp
//////import coil3.compose.AsyncImage
//////import com.example.harakaway.R
////
////@Composable
////
////fun AppliedJobs(innerPaddingValues: PaddingValues){
////    Box(
////        modifier = Modifier.fillMaxSize()
////    ){
////        AsyncImage(
////            model = R.drawable.bg2,
////            contentDescription = "maps",
////            contentScale = ContentScale.Crop,
////            modifier = Modifier
////                .fillMaxWidth()
////        )
////    }
////    Column(
////        verticalArrangement = Arrangement.spacedBy(8.dp),
////        modifier = Modifier
////            .padding(vertical = 16.dp)
////            .verticalScroll(rememberScrollState())
////    ) {
////        Row(
////            verticalAlignment = Alignment.CenterVertically,
////            horizontalArrangement = Arrangement.SpaceBetween,
////            modifier = Modifier
////                .fillMaxWidth()
////                .padding(vertical = 24.dp, horizontal = 16.dp)
////        ){
////            Row{
////                Text(text = "Applied, \nJobs",
////                    fontSize = 32.sp,
////                    lineHeight = 40.sp,
////                )
////            }
////            Column {
////                AsyncImage(
////                    model = R.drawable.super_mario,
////                    contentDescription = "Profile image of user - super mario",
////                    contentScale = ContentScale.Crop,
////                    modifier = Modifier
////                        .size(48.dp)
////                        .clip(CircleShape)
////                        .border(
////                            brush = Brush.horizontalGradient(
////                                colors = listOf(Color.Red, Color.Blue, Color.Green),
////                                startX = 0.0f,
////                                endX = 500.0f,
////                                tileMode = TileMode.Repeated
////                            ),
////                            width = 4.dp,
////                            shape = RoundedCornerShape(32.dp)
////                        )
////                )
////            }
////        }
////        Column {
////            Row(
////                modifier = Modifier
////                    .padding(vertical = 0.5.dp,horizontal = 16.dp)
////            ){
////                Text(
////                    text = "See your applied jobs here.",
////                    color = Color.LightGray
////                )
////            }
////        }
////        var selectedFilter by remember { mutableStateOf("All") }
////        val filters = listOf("All", "Accepted", "Rejected")
////
////        Row(
////            horizontalArrangement = Arrangement.spacedBy(12.dp),
////            modifier = Modifier
////                .fillMaxWidth()
////                .padding(vertical = 8.dp)
////        ) {
////            filters.forEach { filter ->
////                val isSelected = filter == selectedFilter
////                val background = if (isSelected) MaterialTheme.colorScheme.primary else Color(0xFF2C2C2C)
////                val textColor = if (isSelected) Color.White else Color.Gray
////
////                Box(
////                    modifier = Modifier
////                        .clip(RoundedCornerShape(20.dp))
////                        .background(background)
////                        .clickable { selectedFilter = filter }
////                        .padding(horizontal = 16.dp, vertical = 8.dp)
////                ) {
////                    Text(
////                        text = filter,
////                        color = textColor,
////                        style = MaterialTheme.typography.bodyMedium
////                    )
////                }
////            }
////        }
////
////    }
////}