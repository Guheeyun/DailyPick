package com.example.dailypick.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dailypick.presentation.common.Dimens.IndicatorWidth
import com.example.dailypick.presentation.common.Dimens.LargePadding
import com.example.dailypick.presentation.common.Dimens.MediumPadding
import com.example.dailypick.presentation.common.LoginButton
import com.example.dailypick.presentation.common.NewsButton
import com.example.dailypick.presentation.common.NewsTextButton
import com.example.dailypick.presentation.onboarding.component.OnBoardingView
import com.example.dailypick.presentation.onboarding.component.PageIndicator
import com.example.dailypick.ui.theme.CustomTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(){
    Column (modifier = Modifier
        .fillMaxSize()
        .navigationBarsPadding()
        .statusBarsPadding()
    ) {
        val pagerState = rememberPagerState(initialPage = 0){
            pages.size
        }
        HorizontalPager(state = pagerState) { index ->
            OnBoardingView(page = pages[index])
        }

        Spacer(modifier = Modifier.height(MediumPadding))
        //Spacer(modifier = Modifier.weight(1f))//남은 공간 모두 차지
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            PageIndicator(
                modifier = Modifier.width(IndicatorWidth),
                pageSize = pages.size,
                selectedPage = pagerState.currentPage
            )
        }
        Spacer(modifier = Modifier.weight(1f))//남은 공간 모두 차지
        Column(
            modifier = Modifier
                .padding(horizontal = MediumPadding),
            verticalArrangement = Arrangement.Center,
        ){
            val scope = rememberCoroutineScope()

            // 시작하기 버튼
            NewsButton(
                text = "시작하기",
                onClick = {
                    scope.launch {
                        // 로그인하기 버튼 동작
                    }
                }
            )
            // 로그인하기 버튼
            LoginButton(
                onClick = {
                    scope.launch {
                        // 시작하기 버튼 동작
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OnBoardingPagePriview(){
    CustomTheme {
        OnBoardingScreen(

        )
    }
}