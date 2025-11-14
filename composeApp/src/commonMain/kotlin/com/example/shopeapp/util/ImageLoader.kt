package com.example.shopeapp.util

import androidx.compose.runtime.Composable
import coil3.ImageLoader

@Composable
expect fun getAsyncImageLoader(): ImageLoader
