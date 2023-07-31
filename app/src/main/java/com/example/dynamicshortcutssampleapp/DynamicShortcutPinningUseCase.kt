package com.example.dynamicshortcutssampleapp

import android.content.Context
import android.content.pm.ShortcutInfo
import android.graphics.drawable.Icon
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DynamicShortcutPinningUseCase
    @Inject
    constructor(private val context: Context,
                private val buildShortcutPinningInterfaceImpl: BuildShortcutPinningInterface
                ){


    fun getDynamicShortcutInfo(modelShortcutMenuItem : ModelShortcutMenuItem): ShortcutInfo {
        return buildShortcutPinningInterfaceImpl.buildPinnedShortcutInfo(context,
            modelShortcutMenuItem)
    }
}


