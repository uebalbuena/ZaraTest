package com.example.zaratest.service

import com.example.zaratest.model.AllCharacters
import com.example.zaratest.model.ResultsCharacters
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("/api/character")
    fun getCharacter(): Call<AllCharacters>

    @GET("/api/character/{id}")
    fun getSingleCharacter(@Path("id") id: Int): Call<ResultsCharacters>

}