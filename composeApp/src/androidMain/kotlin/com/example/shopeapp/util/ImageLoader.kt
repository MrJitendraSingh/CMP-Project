package com.example.shopeapp.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil3.ImageLoader
import coil3.PlatformContext

@Composable
actual fun getAsyncImageLoader(): ImageLoader {
    // Use Coil's default ImageLoader on Android.
    return ImageLoader.Builder(LocalContext.current as PlatformContext).build()
}
