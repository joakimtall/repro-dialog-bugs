package com.example.dialogbugs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.dialogbugs.ui.theme.DialogBugsTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogBugsTheme {
                Screen()
            }
        }
    }
}

@Composable
private fun Screen() {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(Color.Green)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.hsl(200f, 0.5f, 0.5f))) {
        var showDialog by remember { mutableStateOf(false) }
        Button(onClick = { showDialog = true }) {
            Text(text = "Show dialog")
        }
        if (showDialog) {
            Dialog(onDismissRequest = {}) {
                val systemUiControllerInDialog = rememberSystemUiController()
                SideEffect {
                    systemUiControllerInDialog.setSystemBarsColor(Color.Green)
                }
                Box(modifier = Modifier
                    .size(300.dp, 300.dp)
                    .background(Color.hsl(150f, 0.5f, 0.5f))) {
                    Button(onClick = { showDialog = false }) {
                        Text(text = "Close dialog")
                    }
                }
            }
        }
    }
}