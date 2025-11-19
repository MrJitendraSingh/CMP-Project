package com.example.shopeapp.ui.main.home.model

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class NavigationItem(
    val title: StringResource,
    val icon: DrawableResource,
    val badgeCount: Int? = null
)
