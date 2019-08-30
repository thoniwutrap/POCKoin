package com.mobile.tr.poc.koin.test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mobile.tr.poc.koin.R
import com.mobile.tr.poc.koin.data.local.entity.User
import com.mobile.tr.poc.koin.login.domain.model.LoginRequest
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject

class TestActivity : AppCompatActivity() {


    private val api: PostApi by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        btnGithub.setOnClickListener {
            load()
        }

    }

    fun load() {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            try {
                val user: UsersResponse = api.user("thoniwutrap")
                val user2 = api.user(user.name.toString())
                val user3 = api.user(user.name.toString())
                val user4 = api.user(user.name.toString())
                Log.e("d", "XXX")
            } catch (e: Exception) {
            }

        }
    }
}
