package com.example.harakaway.data.models

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavBarItem(
    var title: String,
    var iconSelected: ImageVector? = null,
    var iconNotSelected: ImageVector? = null,
    val iconCustomSelected: Int? = null,
    val iconCustomNotSelected: Int? = null,
)
