package com.example.kotlinfundamentals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

fun getVolumeTop(height: Int, width: Int, breadth: Int) {
}

class FunctionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_functions)

        getVolume(20, width = 10)
        getVolume(20, 10, 15)

        getVolume(height = 20, breadth = 10, width = 15)

        val isUnit = printVolume(20, 10, 15)
        println(isUnit)

        val arr = intArrayOf(1, 2, 3)
        varargUsage(1, 2, 3, 4)
        varArgUsage(*arr, str = "Volume of the box is")

        this infixUsage 10

        infixUsage(10)

        nestedFun(10, 15)
    }

    private fun printVolume(height: Int, breadth: Int, width: Int) {
        println(height * breadth * width)
    }

    private fun getVolume(height: Int, breadth: Int = 10, width: Int) = height * width * breadth

    private infix fun infixUsage(height: Int): Int = height

    open class Box {
        open fun getVolume(height: Int, width: Int, breadth: Int = 10) {}
    }

    private fun varargUsage(vararg params: Int): Int {
        var volume = 1;

        for (value in params) {
            volume += value
        }
        return volume
    }

    private fun varArgUsage(vararg params: Int, str: String) {
        var volume = 1;

        for (value in params) {
            volume += value
        }
        println("$str $volume")
    }

    class Rectangle : Box() {

        override fun getVolume(height: Int, width: Int, breadth: Int) {
            super.getVolume(height, width, breadth)
        }
    }

    private fun nestedFun(height: Int, width: Int) {

        val breadth = height * 2;

        fun getVolume(height: Int, width: Int): Int {
            return height * width * breadth
        }

        getVolume(height, width)
    }
}
