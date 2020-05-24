package com.example.kotlinfundamentals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FundamentalsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        variables()
        operators()
        stringTemplates()
        conditionalExpressions()
        loops()
        nullability()
    }

    private fun loops() {

        val arrayList = arrayListOf<String>("a", "b", "c")
        for (element in arrayList) {
            print("$element ")
        }

        println()

        for ((index, element) in arrayList.withIndex()) {
            println("$index is $element")
        }

        for (index in 0 until arrayList.size) {
            print(arrayList[index] + ", ")
        }

        println()

        for (index in arrayList.size - 1 downTo 0) {
            print(arrayList[index] + ", ")
        }

        println()

        for (index in 0 until arrayList.size step 2) {
            print(arrayList[index] + ", ")
        }

        println()

        for (element in 'd'..'m') {
            print("$element ")
        }

        println()

        var x = 0
        while (x < arrayList.size) {
            print(arrayList[x] + " ")
            x++;
        }

        println()

        repeat(5) { i ->
            println("We are on the ${i + 1}. loop iteration")
        }
    }

    private fun variables() {
        val a: Int = 0 // immediate assignment by explicitly declaring type
        val b = 0 // type inference
        var c = 10

        c = 2
//        b = 3
    }

    private fun operators() {
        var operatorExample = 10

        operatorExample += 1; // using operators

        // using extension functions
        operatorExample.plus(1) // (Arithmetic operators)
        operatorExample.minus(1) // (Arithmetic operators)
        operatorExample.unaryPlus() // used for +a (unary operator)
        operatorExample.inc() // used for a++ (Increment operator)
    }

    private fun stringTemplates() {
        val hours = 3
        val minutes = 15
        val time = " Time is $hours hours and $minutes minutes"
        println(time)
    }

    private fun conditionalExpressions() {
        fun isNoon(hourOfDay: Int) = if (hourOfDay >= 12) true else false // if as expression

        val type = 12
        when (type) { // properties of when
            0 -> print("Type is 0")
            in 1..10 -> println("Between 1 to 10")
            !in 10..20 -> println("Not in 10 to 20")
            is Int -> println("Type is of Int Type")
            else -> println("Greater than 10")
        }
    }

    private fun nullability() {
        val hourEx: String = "3 hours"
        var minsEx: String? = "15 mins"

//        hourEx = null // cannot assign null to it
//        minsEx = null // can assign null

        println(hourEx.length) // would be called safely
        println(minsEx?.length)
        println(minsEx?.length ?: 0)
        println(minsEx?.length!!.dec())
    }
}
