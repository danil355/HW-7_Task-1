package kz.step.hw_7

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivitySecond : AppCompatActivity() {

var data: Bundle? = null

    fun initializeArguments() {

    data = intent.extras
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initializeArguments()
        initiateProcessData()
        }

    private fun initiateProcessData() {
        val log = data?.getString("Логин")
        val pas = data?.getString("Пароль")
        findViewById<TextView>(R.id.textview_data).setText("Логин: " + log + "\n\n" + "Пароль: " + pas)
    }

}