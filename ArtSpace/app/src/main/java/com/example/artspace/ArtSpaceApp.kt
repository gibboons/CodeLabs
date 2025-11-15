package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview


data class Artwork(
    val imageRes: Int,
    val title: String,
    val artist: String,
    val year: String
)


@Composable
fun ArtSpaceApp() {
    var currentIndex by remember { mutableStateOf(0) }

    val artworks = listOf(
        Artwork(R.drawable.art1, "Starry Night", "Vincent van Gogh", "1889"),
        Artwork(R.drawable.art2, "The Persistence of Memory", "Salvador Dalí", "1931"),
        Artwork(R.drawable.art3, "Mona Lisa", "Leonardo da Vinci", "1503")
    )

    val currentArtwork = artworks[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .shadow(8.dp, RoundedCornerShape(12.dp))
                .clip(RoundedCornerShape(12.dp)),
            color = Color.White
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = currentArtwork.imageRes),
                    contentDescription = currentArtwork.title,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Info Card (Title, Artist, Year)
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(4.dp, RoundedCornerShape(8.dp)),
            color = Color.White,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = currentArtwork.title,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212121),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = currentArtwork.artist,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF616161),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = currentArtwork.year,
                    fontSize = 14.sp,
                    color = Color(0xFF9E9E9E),
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Navigation Buttons (Bottom Fixed)
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    currentIndex =
                        if (currentIndex == 0) artworks.lastIndex else currentIndex - 1
                },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
            ) {
                Text("Previous", fontSize = 16.sp)
            }
            Button(
                onClick = {
                    currentIndex =
                        if (currentIndex == artworks.lastIndex) 0 else currentIndex + 1
                },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
            ) {
                Text("Next", fontSize = 16.sp)
            }
        }
    }
}

@Preview(showBackground = true, name = "Phone Layout")
@Composable
fun ArtSpacePreviewPhone() {
    MaterialTheme {
        ArtSpaceApp()
    }
}
