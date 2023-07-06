package com.example.zaratest.model

import com.google.gson.annotations.SerializedName

class AllCharacters {

    @SerializedName("results")
    lateinit var characterResults: List<ResultsCharacters>
}

class ResultsCharacters(
    val name: String,
    val image: String
)