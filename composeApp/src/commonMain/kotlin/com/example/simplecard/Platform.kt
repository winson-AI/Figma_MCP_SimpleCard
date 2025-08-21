package com.example.simplecard

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform