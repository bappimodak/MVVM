package com.example.bappimodak.kotlinbasicsyntax

import android.arch.lifecycle.ViewModelProviders
import android.arch.lifecycle.Observer
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.bappimodak.kotlinbasicsyntax.model.NicePlaces
import com.example.bappimodak.kotlinbasicsyntax.view.BlogAdapter
import com.example.bappimodak.kotlinbasicsyntax.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mRecyclerView: RecyclerView? = null
    private var mainViewModel: MainViewModel? = null

    private var mBlogAdapter: BlogAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = blogRecyclerView
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        getPopularBlog()
    }

    private fun getPopularBlog() {
        mainViewModel?.getBlog()?.observe(this, Observer { blogList ->
            prepareRecyclerView(blogList)
        })
    }

    private fun prepareRecyclerView(blogList: List<NicePlaces>?) {

        mBlogAdapter = BlogAdapter(blogList)
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView!!.layoutManager = LinearLayoutManager(this)
        } else {
            mRecyclerView!!.layoutManager = GridLayoutManager(this, 4)

        }
        mRecyclerView!!.itemAnimator = DefaultItemAnimator()
        mRecyclerView!!.adapter = mBlogAdapter
    }


    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSave: View = findViewById(R.id.btn_save)
        btnSave.setOnClickListener {
//            coRoutine()
        main()
            println("Before!") // print after delay
        }
    }

    private fun coRoutine(){
        println("Before!") // print after delay
        runBlocking {     // but this expression blocks the main thread
            delay(2000L)  // ... while we delay for 2 seconds to keep JVM alive
        }
        GlobalScope.launch { // launch a new coroutine in background and continue
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            println("World!") // print after delay
        }
        println("Hello,") // main thread continues while coroutine is delayed
//        Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
    }

    fun execute(){
        main()
        println("Before!") // print after delay
    }

    fun main()= runBlocking {
//        launch {
//            delay(200L)
//            println("Task from runBlocking")
//        }
        coroutineScope { // Creates a coroutine scope
            launch {
                delay(500L)
                println("Task from nested launch")
            }

            delay(100L)
            println("Task from coroutine scope") // This line will be printed before the nested launch
        }

        println("Coroutine scope is over") // This line is not printed until the nested launch completes

    }*/
}
