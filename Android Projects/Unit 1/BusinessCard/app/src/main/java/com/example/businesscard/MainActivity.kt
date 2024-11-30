package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Card(name = "Potnuru Mohith", title="Android Developer Extraordinaire", phone = "+91 9876543210", share = "@AndroidDev", email = "mohithp@android.com", modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun Card(name: String, title: String,phone: String, share: String, email: String, modifier: Modifier){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        contentAlignment = Alignment.Center
    ){
        Name(name= name, title = title)
    }
    Box(modifier=Modifier.fillMaxSize().padding(48.dp),
        contentAlignment = Alignment.BottomCenter) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            ContactDetails(icon = Icons.Filled.Phone, message = phone)
            ContactDetails(icon = Icons.Filled.Share, message = share)
            ContactDetails(icon = Icons.Filled.Email, message = email)
        }
    }
}

@Composable
fun Name(name: String, title: String){
    val image = painterResource(R.drawable.androidimage)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.scale(2.5f)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Light,
            fontSize = 48.sp,
            modifier = Modifier.padding(top = 48.dp)
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF267C5D)
        )
    }
}

@Composable
fun ContactDetails(icon: ImageVector, message: String){
    Row {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF267C5D)
        )
        Text(
            text = message,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Card(name = "Potnuru Mohith", title="Android Developer Extraordinaire", phone = "+91 9876543210", share = "@AndroidDev", email = "mohithp@android.com", modifier = Modifier)
    }
}