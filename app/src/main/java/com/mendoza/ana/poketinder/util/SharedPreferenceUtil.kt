package com.mendoza.ana.poketinder.util

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.mendoza.ana.poketinder.data.model.User

class SharedPreferenceUtil {
    companion object {
        private const val SHARED_PREFERENCE_KEY = "SHARED_PREFERENCE_KEY"
        private lateinit var sharedPreference: SharedPreferences
        private const val USER = "USER_KEY"

    }
        fun setSharedPreference(context: Context){
            sharedPreference = context.getSharedPreferences(SHARED_PREFERENCE_KEY,Context.MODE_PRIVATE)
        }
    fun saveUser(user: User){
        val gson = Gson()
        val jsonUser = gson.toJson(user)
        sharedPreference
            .edit()
            .putString(USER,jsonUser)
            .apply()
    }
    fun getUser(): User?{ //parametros de salida
        val gson = Gson()
        var user: User? = null
        val jsonUser = sharedPreference.getString(USER,"")
        user = gson.fromJson(jsonUser, User::class.java)
        return user
    }


}