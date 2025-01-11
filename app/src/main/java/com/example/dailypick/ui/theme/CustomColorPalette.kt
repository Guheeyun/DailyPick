package com.example.dailypick.ui.theme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

data class ExtendedColorScheme(
    val material: ColorScheme,
    val surfaceHighest: Color,
    val onSurfaceHighest: Color,
    val onSurfaceHigh: Color,
    val onSurfaceLow: Color,
    val onSurfaceLowest: Color,
    val onSurfaceContainer: Color,
    val onSurfaceContainerHighest: Color,
    val onSurfaceContainerHigh: Color,
    val onSurfaceContainerLow: Color,
    val onSurfaceContainerLowest: Color,
)

// 라이트 모드 색상 팔레트 정의
val LightExtendedColors = ExtendedColorScheme(
    material = lightColorScheme(
        primary = Primary,
        secondary = Secondary,

        surface = Gray00,

        onSurface = Gray900,

        surfaceContainer = Gray100,
        surfaceContainerHighest = Gray200,
        surfaceContainerHigh = Gray400,
        surfaceContainerLow = Gray600,
        surfaceContainerLowest = Gray800,

        error = State_Red
    ),
    surfaceHighest = Gray100,

    onSurfaceLowest = Gray800,
    onSurfaceLow = Gray600,
    onSurfaceHigh = Gray500,
    onSurfaceHighest = Gray300,

    onSurfaceContainer = Gray900,
    onSurfaceContainerLowest = Gray800,
    onSurfaceContainerLow = Gray600,
    onSurfaceContainerHigh = Gray400,
    onSurfaceContainerHighest = Gray200
)


// 다크 모드 색상 팔레트 정의
val DarkExtendedColors = ExtendedColorScheme(
    material = lightColorScheme(
        primary = Primary,
        secondary = Secondary,

        surface = Gray900,
        onSurface = Gray100,

        surfaceContainer = Gray800,
        surfaceContainerHighest = Gray700,
        surfaceContainerHigh = Gray500,
        surfaceContainerLow = Gray400,
        surfaceContainerLowest = Gray200,

        error = State_Red
    ),
    surfaceHighest = Gray800,

    onSurfaceLowest = Gray200,
    onSurfaceLow = Gray400,
    onSurfaceHigh = Gray600,
    onSurfaceHighest = Gray800,

    onSurfaceContainer = Gray00,
    onSurfaceContainerLowest = Gray200,
    onSurfaceContainerLow = Gray400,
    onSurfaceContainerHigh = Gray500,
    onSurfaceContainerHighest = Gray800
)