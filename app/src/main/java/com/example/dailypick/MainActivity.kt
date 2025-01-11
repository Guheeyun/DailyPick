package com.example.dailypick

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailypick.presentation.onboarding.OnBoardingScreen
import com.example.dailypick.ui.theme.CustomMaterialTheme
import com.example.dailypick.ui.theme.CustomTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<SplashViewModel> ( )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        enableEdgeToEdge()

        installSplashScreen()
            .apply {
                setKeepOnScreenCondition {
                    viewModel.isLoading.value
                }
            }

        setContent {
            // 시스템 다크 모드 상태 확인
            val useDarkTheme = isSystemInDarkTheme()

            // CustomTheme 적용
            CustomTheme(useDarkTheme = useDarkTheme) {
                MyAppContent(viewModel = viewModel)
                OnBoardingScreen()
            }
        }
    }
}

@Composable
fun MyAppContent(viewModel: SplashViewModel) {
    val colors = CustomMaterialTheme.colors // ExtendedColorScheme 가져오기

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface) // 확장된 색상 사용
    ) {
        Text(
            text = "Hello, Custom Theme!",
            color = colors.onSurfaceLow, // 확장된 텍스트 색상 사용
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

class SplashViewModel() : ViewModel() {
    private var _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch {
            delay(2.seconds)
            _isLoading.value = false
        }
    }
}