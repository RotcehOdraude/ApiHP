package com.amaurypm.games.network

import com.amaurypm.games.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Creado por Amaury Perea Matsumura el 12/05/23
 */

object RetrofitService {
    private var INSTANCE: Retrofit? = null

    fun getRetrofit(): Retrofit = INSTANCE ?: synchronized(this){
        val instance = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        INSTANCE = instance

        instance
    }
}