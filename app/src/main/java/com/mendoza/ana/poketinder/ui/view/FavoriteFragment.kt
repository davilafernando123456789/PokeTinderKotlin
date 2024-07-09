package com.mendoza.ana.poketinder.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mendoza.ana.poketinder.R
import com.mendoza.ana.poketinder.data.database.entities.MyPokemonEntity
import com.mendoza.ana.poketinder.databinding.FragmentFavoriteBinding
import com.mendoza.ana.poketinder.databinding.FragmentHomeBinding
import com.mendoza.ana.poketinder.ui.adapter.MyPokemonsAdapter
import com.mendoza.ana.poketinder.ui.viewmodel.FavoriteViewModel

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>
    (FragmentFavoriteBinding::inflate) {

        private val favoriteViewModel: FavoriteViewModel by viewModels()

        private val listMyPokemon = mutableListOf<MyPokemonEntity>()

        private val adapter by lazy { MyPokemonsAdapter(listMyPokemon)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        favoriteViewModel.getMyPokemons(requireContext())

        binding.rvPokemons.adapter = adapter

        favoriteViewModel.myPokemonList.observe(this) { newList ->
            listMyPokemon.clear()
            listMyPokemon.addAll(newList)
            adapter.notifyDataSetChanged()
        }

        binding.floatingActionDelete.setOnClickListener {
            favoriteViewModel.deleteAllPokemon(requireContext())
            listMyPokemon.clear()
            adapter.notifyDataSetChanged()
        }
    }
}