package com.amaurypm.games.model

import com.google.gson.annotations.SerializedName

data class PersonalDetailHP(
    @SerializedName("name"             ) var name            : String?           = null,
    @SerializedName("house"            ) var house           : String?           = null,
    @SerializedName("dateOfBirth"      ) var dateOfBirth     : String?           = null,
    @SerializedName("ancestry"         ) var ancestry        : String?           = null,
    @SerializedName("patronus"         ) var patronus        : String?           = null,
    @SerializedName("actor"            ) var actor           : String?           = null,
    @SerializedName("image"            ) var image           : String?           = null
)