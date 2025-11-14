package com.example.shopeapp.util

import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.PlatformContext

@Composable
actual fun getAsyncImageLoader(): ImageLoader {
    // Use Coil's default ImageLoader on iOS.
    return ImageLoader.Builder(PlatformContext.INSTANCE).build()
}
