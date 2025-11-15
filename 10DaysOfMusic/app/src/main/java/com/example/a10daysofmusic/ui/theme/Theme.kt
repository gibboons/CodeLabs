package com.example.a10daysofmusic.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = IndigoPrimary,
    secondary = CoralSecondary,
    background = LightBackground
)

private val DarkColors = darkColorScheme(
    primary = IndigoPrimary,
    secondary = CoralSecondary
)

@Composable
fun TenDaysOfMusicTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
