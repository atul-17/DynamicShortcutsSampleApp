package com.example.dynamicshortcutssampleapp.something

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dynamicshortcutssampleapp.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a_homescreen)

        //someClass = SomeClass(null)


        println(someClass.doAThing())
    }
}