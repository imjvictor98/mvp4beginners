package com.example.mvp4beginners.login

import com.example.mvp4beginners.remote.LoginRepositoryImpl

class LoginPresenter: LoginContract.Presenter {
    lateinit var view: LoginContract.View //Started inside onCreate's activity method
    private val repository = LoginRepositoryImpl()

    override fun checkLogin(login: String): Boolean {
        if (login.length < 3) {
            view.showError("Login muito curto")
            return false
        }
        return true
    }

    override fun checkPassword(password: String): Boolean {
        if (password.length < 3) {
            view.showError("Senha muito curta")
            return false
        }
        return true
    }

    override fun login(login: String, password: String) {
        view.showLoadingDialog()

        val successfulCallback: () -> Unit = {
            view.hideLoadingDialog()
            view.login()
        }

        val failureCallback: (String) -> Unit = { message ->
            view.hideLoadingDialog()
            view.showError(message)
        }

        repository.login(login, password, successfulCallback, failureCallback)
    }
}