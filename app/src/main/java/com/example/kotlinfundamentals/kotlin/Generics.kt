package com.example.kotlinfundamentals.kotlin

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinfundamentals.onClickListener

class Generics : AppCompatActivity(), onClickListener {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        multipleGenerics("multiple", "generics")
        multipleGenerics(10, 20)
        multipleGenerics(10, "generics")

        genericConstraints(20.0)
        genericConstraints(20f)
    }

    private fun <T> multipleGenerics(param1: T, param2: T) {
        println(param1)
        println(param2)
    }

    private fun <T : Number> genericConstraints(param: T): Int {
        return param.toInt().plus(10)
    }



}