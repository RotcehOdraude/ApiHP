package com.amaurypm.games.model

import com.google.gson.annotations.SerializedName

/**
 * Creado por Amaury Perea Matsumura el 12/05/23
 */
data class Game(
    @SerializedName("id")
    var id: String?,

    @SerializedName("thumbnail")
    var thumbnail: String?,

    @SerializedName("title")
    var title: String?

)
