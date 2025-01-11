package com.example.dailypick.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.dailypick.R

data class Page(
    val title:String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        image = R.drawable.a,
        title = "뉴스를 찾기 어려울 땐\nDaily P!ck"

    ),
    Page(
        image = R.drawable.b,
        title = "P!ck으로 이슈를\n빠르고, 간편하게"

    ),
    Page(
        image = R.drawable.c,
        title = "매일 들어오기 힘들다면\n위젯으로 편하게 보자"
    )

)