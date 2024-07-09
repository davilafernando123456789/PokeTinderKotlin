package com.mendoza.ana.poketinder.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mendoza.ana.poketinder.data.database.entities.MyPokemonEntity

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //suspend fun -> ayudan a poder en un hilo secundario ejecutar un proceso asincrona o suspendida
    suspend fun insert(pokemon:MyPokemonEntity)

    @Query("SELECT * FROM pokemon_table")
    suspend fun getAllPokemons():List<MyPokemonEntity>

    @Query("DELETE FROM pokemon_table")
    suspend fun deleteTable();
}