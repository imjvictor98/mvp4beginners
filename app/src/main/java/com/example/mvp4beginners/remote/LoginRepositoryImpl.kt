package com.example.mvp4beginners.remote

import android.annotation.SuppressLint
import android.os.AsyncTask

class LoginRepositoryImpl: LoginRepository {
    override fun login(
        login: String,
        password: String,
        isSuccessful: () -> Unit,
        isFailure: (String) -> Unit
    ) {

        object : AsyncTask<Void, Void, Boolean>() {
            override fun doInBackground(vararg params: Void?): Boolean {
                Thread.sleep(1200)
                return (login == "joao" && password == "senha")
            }

            override fun onPostExecute(result: Boolean?) {
                result?.let {
                    if (it) {
                        isSuccessful()
                    } else {
                        isFailure("Login incorreto")
                    }
                }
            }
        }.execute()
    }
}