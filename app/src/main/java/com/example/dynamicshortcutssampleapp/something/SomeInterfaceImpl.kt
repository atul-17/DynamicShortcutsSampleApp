package com.example.dynamicshortcutssampleapp.something

import javax.inject.Inject

open class SomeInterfaceImpl
@Inject
constructor(): SomeInterface {
    override fun getAThing() : String{
        return "A Thing"
    }
}