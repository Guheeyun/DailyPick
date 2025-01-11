package com.example.dailypick.presentation.onboarding.component

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.dailypick.presentation.common.Dimens.DotHeight
import com.example.dailypick.presentation.common.Dimens.DotWidth
import com.example.dailypick.presentation.common.Dimens.xxSmallPadding
import com.example.dailypick.ui.theme.CustomMaterialTheme


@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = CustomMaterialTheme.colors.onSurfaceHighest,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageSize) { page ->
            val targetWidth = if (page == selectedPage) DotWidth else DotHeight

            val animatedWidth = animateDpAsState(
                targetValue = targetWidth,
                animationSpec = tween(
                    durationMillis = 100, // 속도 제어를 위한 지속 시간 설정
                    easing = FastOutSlowInEasing // 기본 easing을 사용하여 자연스러운 애니메이션
                )
            ).value

            Box(
                modifier = Modifier
                    .width(animatedWidth) // 애니메이션 된 width 사용
                    .height(DotHeight)
                    .clip(RoundedCornerShape(xxSmallPadding))
                    .background(
                        color = if (page == selectedPage) selectedColor else unselectedColor
                    )
            )
        }
    }
}