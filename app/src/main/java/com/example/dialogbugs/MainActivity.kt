package com.example.dialogbugs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.dialogbugs.ui.theme.DialogBugsTheme

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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun Screen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.hsl(200f, 0.5f, 0.5f))) {
        Dialog(onDismissRequest = {}, properties = DialogProperties(usePlatformDefaultWidth = false)) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.hsl(150f, 0.5f, 0.5f))) {
                Text(text = "Hello Dialog!")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DialogBugsTheme {
        Screen()
    }
}