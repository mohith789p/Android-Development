package com.example.quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrant.ui.theme.QuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Quadrant(
                        title1 = "Text composable",
                        message1 = "Displays text and follows the recommended Material Design guidelines.",
                        title2 = "Image composable",
                        message2 = "Creates a composable that lays out and draws a given Painter class object.",
                        title3 = "Row composable",
                        message3 = "A layout composable that places its children in a horizontal sequence.",
                        title4 = "Column composable",
                        message4 = "A layout composable that places its children in a vertical sequence.",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun Quadrant(title1: String, message1: String, title2: String,message2: String,title3: String,message3: String,title4: String,message4: String, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize().padding(), contentAlignment = Alignment.Center)
    {
        Column() {
            Half(title1 = title1, message1 = message1, color1 = Color(0xFFEADDFF), title2 = title2, message2 = message2, color2 = Color(0xFFD0BCFF), modifier=Modifier.fillMaxHeight(0.5f))
            Half(title1 = title3, message1 = message3, color1 = Color(0xFFB69DF8), title2 = title4, message2 = message4, color2 = Color(0xFFF6EDFF), modifier = Modifier)
        }
    }
}

@Composable
fun Half(title1: String, message1: String,color1: Color ,title2: String, message2: String,color2: Color, modifier: Modifier){
    Box(modifier = modifier) {
        Row() {
            Box(modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight()
                .background(color1), contentAlignment = Alignment.Center) {
                Quarter(title = title1, message = message1)
            }
            Box(modifier = Modifier
                .fillMaxSize()
                .background(color2), contentAlignment = Alignment.Center) {
               Quarter(title = title2, message = message2)
            }
        }
    }
}

@Composable
fun Quarter(title: String, message: String){
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = title, fontWeight = FontWeight.Bold ,modifier = Modifier.padding(16.dp))
        Text(text = message, textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuadrantTheme {
        Quadrant(
            title1 = "Text composable",
            message1 = "Displays text and follows the recommended Material Design guidelines.",
            title2 = "Image composable",
            message2 = "Creates a composable that lays out and draws a given Painter class object.",
            title3 = "Row composable",
            message3 = "A layout composable that places its children in a horizontal sequence.",
            title4 = "Column composable",
            message4 = "A layout composable that places its children in a vertical sequence."
        )
    }
}