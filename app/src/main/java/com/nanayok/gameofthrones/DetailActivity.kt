package com.nanayok.gameofthrones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // calling the action bar
        var actionBar = getSupportActionBar()

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        actionBar?.title = "House Details"



        val newName=intent.getStringExtra("name")
        val newRegion=intent.getStringExtra("region")
        val newCoatOfArms=intent.getStringExtra("coatOfArms")
        //println("newName"+newName)

        val textView: TextView = findViewById(R.id.textViewName) as TextView
        textView.text = newName

        val regionView: TextView = findViewById(R.id.textViewRegion) as TextView
        regionView.text = newRegion

        val coatOfArmsView: TextView = findViewById(R.id.textViewCoatOfArms) as TextView
        coatOfArmsView.text = newCoatOfArms
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}