package com.example.avaliadorcafe

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // PRIMEIRO carrega a tela
        setContentView(R.layout.activity_splash)

        // DEPOIS pega a view
        val logo = findViewById<TextView>(R.id.logoCafe)

        // Animação
        val anim = AnimationUtils.loadAnimation(this, R.anim.splash_logo)
        logo.startAnimation(anim)

        // Delay pra ir pra próxima tela
        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(
                Intent(this, MainActivity::class.java)
            )

            finish()

        }, 2000)
    }
}