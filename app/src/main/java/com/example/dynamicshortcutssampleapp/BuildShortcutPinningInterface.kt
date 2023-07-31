package com.example.dynamicshortcutssampleapp

import android.content.Context
import android.content.pm.ShortcutInfo
import android.graphics.drawable.Icon
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

interface BuildShortcutPinningInterface {

    //to get menu item details
    //fun getPinShortcutMenuItem() : ModelShortcutMenuItem

    fun buildPinnedShortcutInfo(context: Context,
                               modelShortcutMenuItem: ModelShortcutMenuItem) : ShortcutInfo

}