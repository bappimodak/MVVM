package com.example.bappimodak.kotlinbasicsyntax

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DemoRun {
    fun main(args: Array<String>) {
//        println("Before!") // print after delay
        bg()
    }

    fun bg() = runBlocking {
        var job = GlobalScope.launch {
            delay(2000L)
            println("World!")
        }
        println("Hello")
        job.join()
//        delay(4000L)
    }
}