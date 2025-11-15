package com.example.a10daysofmusic.data

import androidx.annotation.DrawableRes

data class MusicTip(
    val day: Int,
    val title: String,
    val description: String,
    @DrawableRes val imageResId: Int
)