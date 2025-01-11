package com.example.dailypick.presentation.common

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.dailypick.ui.theme.CustomMaterialTheme
import com.example.dailypick.ui.theme.Pretendard


@Composable
fun NewsButton(
    text: String,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState()

    Button(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isPressed.value) CustomMaterialTheme.colors.onSurfaceLowest
            else MaterialTheme.colorScheme.primary,
            contentColor = if (isPressed.value) MaterialTheme.colorScheme.onPrimary
            else Color.White
        ),
        interactionSource = interactionSource,
        shape = RoundedCornerShape(size = 6.dp)
    ) {
        Text(
            text = text,
            style = Pretendard.bodyMedium.copy(
                color = MaterialTheme.colorScheme.surface
            ),
        )
    }
}

@Composable
fun NewsTextButton(
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick) {
        Text(
            text = text,
            style = Pretendard.bodyMedium.copy(
                color = CustomMaterialTheme.colors.onSurfaceLowest
            ),
        )
    }
}



@Composable
fun LoginButton(
    onClick: () -> Unit
) {
    TextButton(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(size = 6.dp)

    ) {
        Text(
            text = buildAnnotatedString {
                append("이미 계정이 있나요? ")
                withStyle(
                    style = SpanStyle(
                        color = CustomMaterialTheme.colors.onSurfaceLowest, // 원하는 색상
                        fontWeight = FontWeight.Bold // '로그인'만 SemiBold로 설정
                    )
                ) {
                    append("로그인")
                }
            },
            style = Pretendard.bodyMedium.copy(
                color = CustomMaterialTheme.colors.onSurfaceLow // 기본 스타일
            )
        )
    }
}