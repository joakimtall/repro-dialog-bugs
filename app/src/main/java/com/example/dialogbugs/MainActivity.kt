package com.example.dialogbugs

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import androidx.core.view.WindowCompat
import com.example.dialogbugs.ui.theme.DialogBugsTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            DialogBugsTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Screen()
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun Screen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
    ) {
        var showDialog by remember { mutableStateOf(true) }
        Button(onClick = { showDialog = true }) {
            Text(text = "Show dialog")
        }
        if (showDialog) {
            Dialog(onDismissRequest = {}, properties = DialogProperties(usePlatformDefaultWidth = false)) {
                val dialogColor by remember {
                    mutableStateOf(Color.hsl(Math.random().toFloat() * 255, 0.5f, 0.5f))
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(dialogColor)
                ) {
                }
                Button(onClick = { showDialog = false }) {
                    Text(text = "Close dialog")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DialogBugsTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Screen()
        }
    }
}