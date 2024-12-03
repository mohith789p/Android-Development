package com.example.lemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonapp.ui.theme.LemonAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonAppTheme {
                LemonApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(1) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Yellow
                )
            )
        },
        content = { paddingValues ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                color = MaterialTheme.colorScheme.background
            ) {
                when (currentStep) {
                    1 -> ImageWithText(
                        image = R.drawable.lemon_tree,
                        description = R.string.lemon_tree,
                        message = stringResource(R.string.lemon_tree_description),
                        onClick = { currentStep++ }
                    )
                    2 -> ImageWithText(
                        image = R.drawable.lemon_squeeze,
                        description = R.string.lemon_squeeze,
                        message = stringResource(R.string.lemon_squeeze_description),
                        onClick = { currentStep++ }
                    )
                    3 -> ImageWithText(
                        image = R.drawable.lemon_drink,
                        description = R.string.lemon_drink,
                        message = stringResource(R.string.lemon_drink_description),
                        onClick = { currentStep++ }
                    )
                    4 -> ImageWithText(
                    image = R.drawable.lemon_restart,
                    description = R.string.lemon_restart,
                        message = stringResource(R.string.lemon_restart_description),
                    onClick = { currentStep = 1 }
                    )
                }
            }
        }
    )
}

@Composable
fun ImageWithText(image: Int, description: Int, message: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = stringResource(description),
                modifier = Modifier
                    .background(Color(105, 220, 195), shape = RoundedCornerShape(32.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
                    .clickable { onClick() }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = message,
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonAppTheme {
        LemonApp()
    }
}
