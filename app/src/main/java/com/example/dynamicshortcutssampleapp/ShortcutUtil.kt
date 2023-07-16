package com.example.dynamicshortcutssampleapp

import android.content.Context
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.graphics.drawable.IconCompat

object ShortcutUtil {

    private fun createShorcutInfo(
        context: Context,
        shortLabel : String,
        shorcutId:String,
        longLabel : String,
    ) : ShortcutInfoCompat{
        return ShortcutInfoCompat.Builder(context, shorcutId)
            .setShortLabel(shortLabel)
            .setLongLabel(longLabel)
            .setIcon(IconCompat.createWithResource(context,R.drawable.ic_launcher_foreground))
            .setIntent()
            .build()
    }

}