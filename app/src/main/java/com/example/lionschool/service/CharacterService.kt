package com.example.lionschool.service

import com.example.lionschool.model.CourseList
import retrofit2.Call
import retrofit2.http.GET

interface CharacterService {

    @GET("cursos")
    fun getCharacters(): Call<CourseList>

}