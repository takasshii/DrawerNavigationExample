package com.example.drawerexampleapp

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    var id: String,
    var title: String,
    val contentDescription: String,
    var icon: ImageVector
)