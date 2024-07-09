package com.mendoza.ana.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mendoza.ana.poketinder.data.network.FirebaseRemoteConfigRepository

class SplashViewModel: ViewModel() {
    private var firebaseRemoteConfigRepository = FirebaseRemoteConfigRepository()

    init {
        firebaseRemoteConfigRepository.init()
    }
    fun getIsUnderMaintenance(): MutableLiveData<Boolean>{
        return firebaseRemoteConfigRepository.isUnderMaintenanceLiveData

    }
}
