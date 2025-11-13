package com.example.shopeapp

import androidx.compose.ui.window.ComposeUIViewController
import com.example.shopeapp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }