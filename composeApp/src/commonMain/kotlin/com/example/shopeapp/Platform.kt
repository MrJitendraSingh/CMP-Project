package com.example.shopeapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform