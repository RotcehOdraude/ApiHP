package com.amaurypm.games.model

import com.google.gson.annotations.SerializedName

/**
 * Creado por Amaury Perea Matsumura el 12/05/23
 */
data class GameDetail(
    @SerializedName("title")
    var title: String?,

    @SerializedName("image")
    var image: String?,

    @SerializedName("long_desc")
    var longDesc: String?
)
