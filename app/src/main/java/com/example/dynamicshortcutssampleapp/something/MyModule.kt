package com.example.dynamicshortcutssampleapp.something

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class MyModule{
    @Binds
   abstract fun bindSomeDependency(
        someImpl: SomeInterfaceImpl
    ) : SomeInterface

}

