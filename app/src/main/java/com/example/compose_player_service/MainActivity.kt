package com.example.compose_player_service

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Column(
                    Modifier
                        .fillMaxSize()
                        .background(Color(0xff222d40))
                        .systemBarsPadding()
                ) {
//                    Player()
                    PlayGround(this@MainActivity)
                }
            }
        }
    }
}

@Composable
fun PlayGround(context: Context) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        val intent = Intent(context, MusicService::class.java)
        context.startForegroundService(intent)

        Log.i("kitty", "Service start command sent")
    }
}

@Preview(device = "id:pixel_2")
@Composable
fun Player() {
    Box(
        Modifier
            .fillMaxSize()
    ) {
        Row(
            Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .padding(horizontal = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.arrow_down),
                    tint = Color.White,
                    modifier = Modifier.size(30.dp),
                    contentDescription = ""
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.offline),
                    tint = Color.White,
                    modifier = Modifier.size(30.dp),
                    contentDescription = ""
                )
            }
        }
        Column(
            Modifier
                .align(Alignment.Center)
                .padding(horizontal = 40.dp)
                .padding(top = 10.dp)
        ) {
            BoxWithConstraints {
                Image(
                    painter = painterResource(R.drawable.ocean_cover),
                    contentDescription = "ocean cover", modifier = Modifier
                        .size(maxWidth)
                        .clip(RoundedCornerShape(15.dp))
                )
            }
            Sh(20.dp)
            Column(
                Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WhiteText(
                    "Ocean",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
                Sh()
                Slider(
                    value = 0f,
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    colors = SliderDefaults.colors(
                        thumbColor = Color.White,
                        inactiveTrackColor = Color.White,
                        activeTrackColor = Color.White,
                        activeTickColor = Color.White
                    )
                )
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    WhiteText("00:00")
                    WhiteText("05:00")
                }
            }
            Sh(20.dp)
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                IconButton(
                    onClick = {
                    },
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.previous),
                        tint = Color.White,
                        modifier = Modifier.size(40.dp),
                        contentDescription = "play"
                    )
                }
                Sw()
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Color(0xff325585))
                ) {
                    Icon(
                        painter = painterResource(R.drawable.play),
                        tint = Color.White,
                        modifier = Modifier.size(60.dp),
                        contentDescription = "play"
                    )
                }
                Sw()
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.next),
                        tint = Color.White,
                        modifier = Modifier.size(40.dp),
                        contentDescription = "play"
                    )
                }
            }
        }
    }
}