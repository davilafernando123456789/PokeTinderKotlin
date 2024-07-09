package com.mendoza.ana.poketinder.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mendoza.ana.poketinder.data.database.dao.PokemonDao
import com.mendoza.ana.poketinder.data.database.entities.MyPokemonEntity
//modificar datos sencibles a la tabla, elimar columnas y tablas -> versiones
@Database(entities = [MyPokemonEntity::class], exportSchema = false, version = 1)
abstract class PokemonDatabase: RoomDatabase(){
    abstract fun getPokemonDao(): PokemonDao
}