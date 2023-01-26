package com.example.adaptivescreencompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.adaptivescreencompose.ui.theme.AdaptiveScreenComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdaptiveScreenComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowInfo = rememberWindowInfo()

                    when (windowInfo.screenWidthInfo) {
                        is WindowInfo.WindowType.Compact -> {
                            CompactMode(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                            )
                        }
                        is WindowInfo.WindowType.Medium -> {
                            MediumMode(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                            )
                        }
                        else -> {
                            ExpandedMode(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CompactMode(
    modifier: Modifier = Modifier
) {
    Surface(color = Color.Green) {
        Text(text = "Content")
    }
}

@Composable
fun MediumMode(
    modifier: Modifier = Modifier
) {
    Row {
        Surface(
            modifier = modifier.weight(1f),
            color = Color.Magenta
        ) {
            Text(text = "Content 1")
        }

        Surface(
            modifier = modifier.weight(1f),
            color = Color.DarkGray,
        ) {
            Text(text = "Content 2")
        }
    }
}

@Composable
fun ExpandedMode(
    modifier: Modifier = Modifier
) {
    Row {
        Surface(
            modifier = modifier.weight(1f),
            color = Color.Magenta
        ) {
            Text(text = "Content 1")
        }

        Surface(
            modifier = modifier.weight(1f),
            color = Color.DarkGray,
        ) {
            Text(text = "Content 2")
        }

        Surface(
            modifier = modifier.weight(1f),
            color = Color.Yellow,
        ) {
            Text(text = "Content 3")
        }
    }
}
