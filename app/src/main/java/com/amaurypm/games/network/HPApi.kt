package com.amaurypm.games.network

import com.amaurypm.games.model.Game
import com.amaurypm.games.model.GameDetail
import com.amaurypm.games.model.StaffDetailHP
import com.amaurypm.games.model.StaffHP
import com.amaurypm.games.model.StudentDetailHP
import com.amaurypm.games.model.StudentHP
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface HPApi {

    @GET("/student")
    fun getStudents(
        @Url url: String?    //getStudents("api/characters/students")
    ): Call<ArrayList<StudentHP>>

    @GET("/staff")
    fun getStaff(
        @Url url: String?    //getStudents("api/characters/staff")
    ): Call<ArrayList<StaffHP>>

    @GET("/api/character/{id}")    //getStudentDetail("3763783")   /api/character/{3763783}
    fun getStudentDetail(
        @Query("id") id: String?
    ): Call<StudentDetailHP>

    @GET("/api/character/{id}")    //getStaffDetail("3763783")   /api/character/{3763783}
    fun getStaffDetail(
        @Query("id") id: String?
    ): Call<StaffDetailHP>
}