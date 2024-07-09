package com.mendoza.ana.poketinder.data.model

import com.google.gson.annotations.SerializedName
import com.mendoza.ana.poketinder.data.model.PokemonResponse

data class PokemonListResponse(
    //llave del json count
    @SerializedName("count") val count: Int,
    //Array list
    @SerializedName("results") val results: List<PokemonResponse>
)

//Serializename-la llave se agrega como buena práctica de programación