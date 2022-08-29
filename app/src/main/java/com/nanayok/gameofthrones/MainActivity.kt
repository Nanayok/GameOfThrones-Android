package com.nanayok.gameofthrones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nanayok.gameofthrones.Adapter.CustomAdapter
import com.nanayok.gameofthrones.Models.ItemsViewModel
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    // on below line we are creating a variable.
    //lateinit var showProgressBtn: Button
    lateinit var loadingPB: ProgressBar
    //var isProgressVisible = false
    //var list = arrayListOf<String>()
    //var str: String? = null // works
    var apiDatatoLoad: String? = null
    val data = ArrayList<ItemsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileName=intent.getStringExtra("apiResponseData")
        println("profile"+profileName)
        apiDatatoLoad = profileName

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        val housesJSONArray = JSONArray(apiDatatoLoad)
        for (i in 0 until housesJSONArray.length()) {
            val house = housesJSONArray.getJSONObject(i)
            //println("${book.get("book_name")} by ${book.get("author")}")
            println(house.get("name"))
            data.add(ItemsViewModel(R.drawable.ic_baseline_home_24,
                house.get("name").toString(), house.get("region").toString(), house.get("coatOfArms").toString()
            ))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }
}