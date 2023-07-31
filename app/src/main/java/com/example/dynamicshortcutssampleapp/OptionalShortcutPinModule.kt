package com.example.dynamicshortcutssampleapp

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class OptionalShortcutPinModule {
    @Singleton
    @Binds
    abstract fun bindOptionalShortcutForHomescreen(
        enableShortcutPinningImpl: EnableShortcutPinningInterfaceImpl)
            : BuildShortcutPinningInterface

    @Binds
    abstract fun bindApplicationContext(@ApplicationContext context: Context) : Context



}
