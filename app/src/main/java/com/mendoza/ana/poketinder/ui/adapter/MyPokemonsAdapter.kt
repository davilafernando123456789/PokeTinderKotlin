package com.mendoza.ana.poketinder.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mendoza.ana.poketinder.R
import com.mendoza.ana.poketinder.data.database.entities.MyPokemonEntity
import com.mendoza.ana.poketinder.ui.holder.MyPokemonsHolder

class MyPokemonsAdapter (val list: List<MyPokemonEntity>):
RecyclerView.Adapter<MyPokemonsHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPokemonsHolder {
        val view = parent.inflate(R.layout.item_pokemon_saved)
        return MyPokemonsHolder(view)
    }

    override fun onBindViewHolder(holder: MyPokemonsHolder, position: Int ) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size

}