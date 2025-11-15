package com.example.a10daysofmusic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.a10daysofmusic.data.MusicData
import com.example.a10daysofmusic.ui.MusicTipCard
import com.example.a10daysofmusic.ui.theme.TenDaysOfMusicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TenDaysOfMusicTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MusicTipsScreen()
                }
            }
        }
    }
}

@Composable
fun MusicTipsScreen() {
    androidx.compose.foundation.layout.Column {
        androidx.compose.material3.Text(
            text = "10 Days of Music",
            style = MaterialTheme.typography.headlineMedium,
            modifier = androidx.compose.ui.Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
        )
        androidx.compose.foundation.lazy.LazyColumn {
            items(MusicData.tips) { tip ->
                MusicTipCard(tip)
            }
        }
    }
}
