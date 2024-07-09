package com.mendoza.ana.poketinder.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PokemonResponse(

    @SerializedName("name") val name: String,
    //penultimo un número representa el identificador de tu pokemon - se puede obtener el id
    @SerializedName("url") val url: String
) : Serializable {

    fun getPokemonId() = getIdPokemonFromUrl(url)

    fun getIdPokemonFromUrl(url: String) : String = url.split("/").toTypedArray()[6]
    //id permite retornar la imagen
    fun getPokemonImage(): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${getPokemonId()}.png"
}

