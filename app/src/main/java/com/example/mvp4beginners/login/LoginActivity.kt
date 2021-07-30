package com.example.mvp4beginners.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.mvp4beginners.R
import com.example.mvp4beginners.forgot.ForgotPasswordActivity

class LoginActivity : AppCompatActivity(), LoginContract.View {
    //late init variables
    private val btnOk: Button by lazy { findViewById(R.id.btnOk) }
    private val edtLogin: EditText by lazy { findViewById(R.id.edtLogin) }
    private val edtPassword: EditText by lazy { findViewById(R.id.edtPassword) }
    private val loading: FrameLayout by lazy { findViewById(R.id.loading) }
    private val btnForgot: Button by lazy { findViewById(R.id.btnForgot) }

    //presenter
    private val presenter = LoginPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        presenter.view = this

        btnOk.setOnClickListener {
            val login = edtLogin.text.toString()
            val password = edtPassword.text.toString()

            if (!presenter.checkLogin(login)) return@setOnClickListener
            if (!presenter.checkPassword(password)) return@setOnClickListener

            presenter.login(login, password)
        }

        btnForgot.setOnClickListener {
            val email = edtLogin.text.toString()
            presenter.doForgotPassword(email)
        }


    }

    override fun showLoadingDialog() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoadingDialog() {
        loading.visibility = View.GONE
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun login() {
        Toast.makeText(this, "Ir para a proxima tela...", Toast.LENGTH_LONG).show()
    }

    override fun forgotPassword() {
        val intent = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(intent)
    }
}