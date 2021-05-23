package com.example.esiea3a.presentation.api

data class ColorDetailResponse(
    val title: String,
    val id: Int,
    val url: String,
    val rgb: List<ColorRGB>,
    val hsv: List<ColorHSV>,
    val imageUrl: String
)

data class ColorRGB (
    val red: Int,
    val green: Int,
    val blue: Int
)

data class ColorHSV (
    val hue: Int,
    val saturation: Int,
    val value: Int
)