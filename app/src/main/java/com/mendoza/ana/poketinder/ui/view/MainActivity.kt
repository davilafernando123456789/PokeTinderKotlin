package com.mendoza.ana.poketinder.ui.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Toast
import com.mendoza.ana.poketinder.R
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mendoza.ana.poketinder.ui.adapter.PokemonAdapter
import com.mendoza.ana.poketinder.data.model.PokemonResponse
import com.mendoza.ana.poketinder.data.network.PokemonApi
import com.mendoza.ana.poketinder.databinding.ActivityMainBinding
import com.mendoza.ana.poketinder.ui.viewmodel.MainViewModel
import com.yuyakaido.android.cardstackview.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate){
    private val viewModel by lazy {MainViewModel()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController)
    }
    override fun OnCardDragging(direction: Direction?, ratio: Float) {}
    override fun OnCardRewound() {}
}