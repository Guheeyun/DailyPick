package com.example.dailypick.presentation.onboarding.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.dailypick.presentation.common.Dimens.MediumPadding

import com.example.dailypick.presentation.common.Dimens.SmallPadding
import com.example.dailypick.presentation.common.Dimens.xLargePadding
import com.example.dailypick.presentation.common.Dimens.xxSmallPadding
import com.example.dailypick.presentation.common.NewsTextButton
import com.example.dailypick.presentation.onboarding.Page
import com.example.dailypick.presentation.onboarding.pages
import com.example.dailypick.ui.theme.CustomMaterialTheme
import com.example.dailypick.ui.theme.CustomTheme
import com.example.dailypick.ui.theme.Pretendard
import kotlinx.coroutines.launch

@Composable
fun OnBoardingView(
    modifier: Modifier = Modifier,
    page: Page
) {
    Column(
        modifier = modifier
            //.fillMaxSize() // Column이 화면 전체를 채우도록 설정
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = SmallPadding),
        horizontalAlignment = Alignment.End
    ) {

        NewsTextButton(
            text = "건너뛰기",
            onClick = {
                }
        )
        Spacer(modifier = Modifier.height(MediumPadding)) // 상단 간격

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = page.title,
            style = Pretendard.titleLarge.copy(
                color = CustomMaterialTheme.colors.onSurfaceLowest
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(MediumPadding)) // Text와 Image 간 간격

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.7f) // 고정된 비율 설정
                .padding(horizontal = 26.dp)
                .clip(RoundedCornerShape(xxSmallPadding))
                .background(CustomMaterialTheme.colors.onSurfaceContainerHighest),
        )
    }
}


@Preview(showBackground = true)
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OnBoardingPagePriview(){
    CustomTheme {
        OnBoardingView(
            page = pages[0]
        )
    }
}