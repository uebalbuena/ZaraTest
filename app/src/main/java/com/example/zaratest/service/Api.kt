package com.example.zaratest.service

import com.example.zaratest.model.AllCharacters
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("/api/character")
    fun getCharacter(): Call<AllCharacters>

}