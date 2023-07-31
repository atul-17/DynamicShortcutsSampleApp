package com.example.dynamicshortcutssampleapp

import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.graphics.drawable.AdaptiveIconDrawable
import android.graphics.drawable.Icon
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class EnableShortcutPinningInterfaceImpl :  BuildShortcutPinningInterface{

    @Inject
    constructor()

    //R.drawable.iot_device)

    override fun buildPinnedShortcutInfo(
        context: Context,
        modelShortcutMenuItem: ModelShortcutMenuItem) : ShortcutInfo {

        val intent = Intent(context, ActivityB::class.java)
        intent.action = Intent.ACTION_VIEW

        return ShortcutInfo.Builder(context, "mask_up")
            .setShortLabel(modelShortcutMenuItem.shortLabel)
            .setRank(0)
            .setLongLabel(modelShortcutMenuItem.longLabel)
            .setIcon(modelShortcutMenuItem.icon)
            .setIntent(intent)
            .build()

        }
}