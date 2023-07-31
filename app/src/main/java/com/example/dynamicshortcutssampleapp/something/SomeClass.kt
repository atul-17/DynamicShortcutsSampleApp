package com.example.dynamicshortcutssampleapp.something

import javax.inject.Inject

class SomeClass
@Inject
constructor(
    val someInterfaceImpl: SomeInterface?
){
    fun doAThing(): String{
        return "Look I got: ${someInterfaceImpl?.getAThing()}"
    }
}