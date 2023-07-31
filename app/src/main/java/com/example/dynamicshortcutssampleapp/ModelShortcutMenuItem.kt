package com.example.dynamicshortcutssampleapp

import android.graphics.drawable.Icon
import androidx.core.graphics.drawable.IconCompat

data class ModelShortcutMenuItem(
    val shortLabel : String,
    val longLabel : String,
    val icon : Icon
)
