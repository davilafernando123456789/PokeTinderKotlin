package com.mendoza.ana.poketinder.ui.view

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.gms.tasks.OnCanceledListener
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.InstanceIdResult
import com.mendoza.ana.poketinder.databinding.ActivitySplashBinding
import com.mendoza.ana.poketinder.ui.viewmodel.SplashViewModel
import com.yuyakaido.android.cardstackview.Direction

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener (OnCompleteListener  <InstanceIdResult> { task ->
                if(!task.isSuccessful){
                    Log.w(
                        TAG, "getInstanceId failed"
                    )
                    return@OnCompleteListener
                }
                //Get new Instance ID token
                val token = task.result.token
                Log.e(
                    "FIREBASE TOKEN", "Token: $token"
                )
            })

        splashViewModel.getIsUnderMaintenance().observe(this) { isUnderMaintenance ->
            if (isUnderMaintenance) {
                Toast.makeText(this, "Bajo Mantenimiento", Toast.LENGTH_SHORT).show()
            } else {
                showAnimation()
            }
        }
    }

    override fun OnCardDragging(direction: Direction?, ratio: Float) {
        TODO("Not yet implemented")
    }

    override fun OnCardRewound() {
        TODO("Not yet implemented")
    }

    private fun showAnimation() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 3000)
    }
}