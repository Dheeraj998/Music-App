package com.example.musicapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {


    @Headers("x-rapidapi-key: 23d354617cmsh25ac2aede52dc67p1f508ajsn68f129f4f831"+"x-rapidapi-host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q")query: String):Call<MyData>
}