package com.example.dynamicshortcutssampleapp

import android.annotation.TargetApi
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.graphics.drawable.IconCompat
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainLauncherActivity : AppCompatActivity() {

    /**this will be runtime flag whether to enable / disable  */
    var runtimeEnableDisablePinShortcutMenuItem : Boolean = false

    lateinit var shortcutManager : ShortcutManager

    @Inject
    lateinit var dynamicShortcutPinningUseCase : DynamicShortcutPinningUseCase

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a_homescreen)

        runtimeEnableDisablePinShortcutMenuItem = true


      shortcutManager = getSystemService(ShortcutManager::class.java)


        val btnSetShortcut = findViewById(R.id.btnSetShortcut) as AppCompatButton

        btnSetShortcut.setOnClickListener {
            if (runtimeEnableDisablePinShortcutMenuItem) {
                //adds a shortcut to the home-screen
                shortcutManager?.requestPinShortcut(dynamicShortcutPinningUseCase
                    .getDynamicShortcutInfo(
                        ModelShortcutMenuItem("shortLabel",
                        "longLabel",
                            Icon.createWithResource(this@MainLauncherActivity,R.drawable.iot_device))
                    ),
                    getPendingIntent().intentSender)
            }
        }
    }

    private fun getPendingIntent() : PendingIntent{
        return PendingIntent.getBroadcast(
            this@MainLauncherActivity,
            1,
            intent,
            PendingIntent.FLAG_IMMUTABLE,
        )
    }


    @TargetApi(25)
    /**
     * Create a dynamic pinned shortcut
     * so when user long clicks on the app
     * it shows the shortcuts
     */
    private fun buildDynamicPinnedShortcuts() {
        val intent = Intent(applicationContext, ActivityB::class.java)
        intent.action = Intent.ACTION_VIEW

        val shortcut1 = ShortcutInfo.Builder(applicationContext, "mask_up")
            .setShortLabel("Shortcut1")
            .setRank(0)
            .setLongLabel("Open Shortcut1")
            .setIcon(Icon.createWithResource(applicationContext, R.drawable.iot_device))
            .setIntent(intent)
            .build()

        val shortcut2 = ShortcutInfo.Builder(applicationContext, "web_link")
            .setShortLabel("Shortcut1")
            .setRank(1)
            .setLongLabel("Open Shortcut2")
            .setIcon(Icon.createWithResource(applicationContext, R.drawable.iot_device))
            .setIntent(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com/")
                )
            )
            .build()

        shortcutManager?.dynamicShortcuts = listOf(shortcut1, shortcut2)
    }

    @TargetApi(25)
    private fun removeShortcuts() {
        val manager = getSystemService(ShortcutManager::class.java)
        manager.removeAllDynamicShortcuts()
    }


}