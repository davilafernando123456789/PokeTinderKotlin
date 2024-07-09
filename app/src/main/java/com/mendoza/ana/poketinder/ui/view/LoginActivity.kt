package com.mendoza.ana.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.mendoza.ana.poketinder.data.model.User
import com.mendoza.ana.poketinder.databinding.ActivityLoginBinding
import com.mendoza.ana.poketinder.ui.viewmodel.LoginViewModel
import com.mendoza.ana.poketinder.util.SharedPreferenceUtil
import com.yuyakaido.android.cardstackview.Direction

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnLogin.setOnClickListener {
            startLogin()
        }

        binding.btnRegister.setOnClickListener {
            startActivity( Intent (this, RegisterActivity::class.java))
        }

        loginViewModel = LoginViewModel(this)

        loginViewModel.onCreate()

        loginViewModel.emptyFieldsError.observe(this) {
            Toast.makeText(this, "Ingrese datos de usauario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.fieldsAuthenticateError.observe(this) {
            Toast.makeText(this, "Erro de usuario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.goSuccessActivity.observe(this) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun OnCardDragging(direction: Direction?, ratio: Float) { }
    override fun OnCardRewound() {}

    fun startLogin() {
        loginViewModel.validateInputs(
            binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString()
        )
    }
}