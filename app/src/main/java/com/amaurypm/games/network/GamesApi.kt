package com.amaurypm.games.network

import com.amaurypm.games.model.Game
import com.amaurypm.games.model.GameDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface GamesApi {

    @GET
    fun getGames(
        @Url url: String?    //getGames("cm/games/games_list.php")
    ): Call<ArrayList<Game>>

    @GET("cm/games/game_detail.php")    //getGameDetail("3763783", "amaury")   cm/games/game_detail.php?id=3763783&name=Amaury
    fun getGameDetail(
        @Query("id") id: String? /*,
        @Query("name") name: String?*/
    ): Call<GameDetail>

    @GET("games/game_detail/{id}")   //getGameDetailApiary("433243", "amaury")     //game/game_detail/433243/amaury
    fun getGameDetailApiary(
        @Path("id") id: String?/*,
        @Path ("nombre") nombre: String?*/
    ): Call<GameDetail>

}