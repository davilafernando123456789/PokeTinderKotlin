package com.mendoza.ana.poketinder.ui.viewmodel

import android.content.Context
import com.mendoza.ana.poketinder.util.SharedPreferenceUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mendoza.ana.poketinder.data.model.User

class LoginViewModel (private val context: Context): ViewModel() {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    val emptyFieldsError = MutableLiveData<Boolean>()
    val fieldsAuthenticateError = MutableLiveData<Boolean>()
    val goSuccessActivity = MutableLiveData<Boolean>()

    fun onCreate() {
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }
    fun validateInputs(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            emptyFieldsError.postValue(true)
        }
        val user: User? = sharedPreferenceUtil.getUser()

        if (email.equals(user?.email) && password.equals(user?.password)) {
            goSuccessActivity.postValue(true)
        } else {
            fieldsAuthenticateError.postValue(true)
        }
    }
}