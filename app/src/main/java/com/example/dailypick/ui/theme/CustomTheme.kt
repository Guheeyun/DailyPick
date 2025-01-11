package com.example.dailypick.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalExtendedColorScheme = staticCompositionLocalOf { LightExtendedColors }

@Composable
fun CustomTheme(
    useDarkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val extendedColors = if (useDarkTheme) DarkExtendedColors else LightExtendedColors

    CompositionLocalProvider(LocalExtendedColorScheme provides extendedColors) {
        MaterialTheme(
            colorScheme = extendedColors.material, // 기본 Material ColorScheme
            typography = Pretendard,
            content = content
        )
    }
}

object CustomMaterialTheme {
    val colors: ExtendedColorScheme
        @Composable
        get() = LocalExtendedColorScheme.current
}