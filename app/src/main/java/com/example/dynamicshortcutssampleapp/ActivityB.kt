package com.example.dynamicshortcutssampleapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlin.jvm.internal.Intrinsics.Kotlin

class ActivityB : AppCompatActivity() {
    var shortcutId = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_layout)

        var bundle  = intent.extras

        shortcutId = bundle?.getString("shortcutId","000")?:"000"

        Log.d("TAG", "shortcutId_fromPendingIntent: $shortcutId")

    }
}