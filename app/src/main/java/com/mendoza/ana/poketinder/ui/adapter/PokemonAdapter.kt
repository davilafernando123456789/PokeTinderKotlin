package com.mendoza.ana.poketinder.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mendoza.ana.poketinder.R
import com.mendoza.ana.poketinder.data.model.PokemonResponse
import com.mendoza.ana.poketinder.databinding.ItemPokemonBinding
import javax.security.auth.callback.Callback

class PokemonAdapter (
    var list: List<PokemonResponse>,
    val callback: Callback
    ) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_pokemon)
        return  ViewHolder(view)
    }
     //inyectar la informacion en cada vista
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size

     inner class ViewHolder (view: View): RecyclerView.ViewHolder(view){
         private val binding = ItemPokemonBinding.bind(view)

         fun bind(pokemon:PokemonResponse){
             with(binding){
                 root.setOnClickListener{
                     callback.onClickPokemonInformation(pokemon)
                 }
                 tvName.text = pokemon.name
                 Glide
                     .with(itemView)
                     .load(pokemon.getPokemonImage())
                     .into(binding.ivPokemon)
             }
         }
     }
    interface Callback{
        fun onClickPokemonInformation(pokemon: PokemonResponse)
    }
    }
    fun ViewGroup.inflate(layoutRes: Int):View =
        LayoutInflater.from(context).inflate(layoutRes, this, false);

