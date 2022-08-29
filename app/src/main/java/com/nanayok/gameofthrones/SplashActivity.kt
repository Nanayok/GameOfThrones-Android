package com.nanayok.gameofthrones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.nanayok.gameofthrones.Objects.RequestHandler
import org.json.JSONArray

class SplashActivity : AppCompatActivity() {

    var apiData: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({

            Thread(Runnable {
                val resp =  RequestHandler.requestGET("https://www.anapioficeandfire.com/api/houses")
                println("ResponseData"+resp)

                apiData = resp

                val housesJSONArray = JSONArray(resp)
//            for (i in 0 until booksJSONArray.length()) {
//                val book = booksJSONArray.getJSONObject(i)
//                println("${book.get("book_name")} by ${book.get("author")}")
//            }
                for (i in 0 until housesJSONArray.length()) {
                    val house = housesJSONArray.getJSONObject(i)
                    //println("${book.get("book_name")} by ${book.get("author")}")
                    println(house.get("name"))
                }
                println("newData"+apiData)

                val intent = Intent(this, MainActivity::class.java)
                println("newData1"+apiData)
                intent.putExtra("apiResponseData",apiData)
                startActivity(intent)

            }).start()

//            val intent = Intent(this, MainActivity::class.java)
//            println("newData1"+apiData)
//            intent.putExtra("apiResponseData",apiData)
//            startActivity(intent)
            finish()
//        }, 3000) // 3000 is the delayed time in milliseconds.
        }, 3000) // 3000 is the delayed time in milliseconds.

    }
}