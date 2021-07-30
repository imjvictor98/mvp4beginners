package com.example.mvp4beginners.login

interface LoginContract {
    interface View {
        //Show loading
        fun showLoadingDialog()
        //Hide loading
        fun hideLoadingDialog()
        //Show Toast Error
        fun showError(message: String)
        //Login
        fun login()

        fun forgotPassword()
    }

    interface Presenter {
        //Check login is Valid
        fun checkLogin(login: String): Boolean
        //Check password is Valid
        fun checkPassword(password: String): Boolean
        //Do login (showToast)
        fun login(login: String, password: String)

        fun doForgotPassword(email: String)
    }
}