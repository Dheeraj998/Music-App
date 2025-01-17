package com.example.musicapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofitBuilder=Retrofit.Builder().baseUrl("https://deezerdevs-deezer.p.rapidapi.com/").addConverterFactory(GsonConverterFactory.create()).build().create(ApiInterface::class.java)


        val retrofitData=retrofitBuilder.getData("eminem")

        retrofitData.enqueue(object : Callback<MyData?>{
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val dataList=response.body()
                val textView=findViewById<TextView>(R.id.helloText)
//                textView.text=dataList.toString()
                Log.d("TAG: onResponse","onResponse:"+response.raw())
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("TAG: onFailure","onFailure:"+t.message)
            }
        })

    }
}