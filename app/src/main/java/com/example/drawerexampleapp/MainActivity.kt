package com.example.drawerexampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.drawerexampleapp.ui.theme.DrawerExampleAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrawerExampleAppTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        AppBar(onNavigationIconClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        })
                    },
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "home",
                                    title = "Home",
                                    contentDescription = "Go to home screen",
                                    icon = Icons.Default.Home
                                ),
                                MenuItem(
                                    id = "setting",
                                    title = "Setting",
                                    contentDescription = "Go to setting screen",
                                    icon = Icons.Default.Settings
                                ),
                                MenuItem(
                                    id = "info",
                                    title = "Info",
                                    contentDescription = "Go to info screen",
                                    icon = Icons.Default.Info
                                )
                            ), onItemClick = {
                                println("Click on ${it.title}")
                            }
                        )
                    }) {
                }
            }
        }
    }
}
