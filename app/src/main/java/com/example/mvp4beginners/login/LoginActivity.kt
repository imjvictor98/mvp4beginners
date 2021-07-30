package com.example.mvp4beginners.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.mvp4beginners.R

class LoginActivity : AppCompatActivity(), LoginContract.View {
    //late init variables
    private lateinit var buttonOk: Button
    private lateinit var edtLogin: EditText
    private lateinit var edtPassword: EditText
    private lateinit var loading: FrameLayout

    //presenter
    private val presenter = LoginPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonOk = findViewById(R.id.buttonOk)
        edtLogin = findViewById(R.id.edtLogin)
        edtPassword = findViewById(R.id.edtPassword)
        loading = findViewById(R.id.loading)

        presenter.view = this

        buttonOk.setOnClickListener {
            val login = edtLogin.text.toString()
            val password = edtPassword.text.toString()

            if (!presenter.checkLogin(login)) return@setOnClickListener
            if (!presenter.checkPassword(password)) return@setOnClickListener

            presenter.login(login, password)
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
}