package kz.step.hw_7

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var editTextLogin: EditText? = null
    var editTextPassword: EditText? = null
    var buttonRegistration: Button? = null

    companion object {
        const val REQUEST_CODE_RESULT = 1
        const val KEY_PERSONS_NAME = "KEY_PERSONS_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        initializeViews()
        initializeLiseners()
    }

    private fun initializeViews() {
        editTextLogin = findViewById(R.id.edittext_login)
        editTextPassword = findViewById(R.id.password_toggle)
        buttonRegistration = findViewById(R.id.buttonPanel)
    }

    private fun initializeLiseners() {


        buttonRegistration?.setOnClickListener {
            initiateDisplaySecondActivity()
        }
    }

    fun initiateDisplaySecondActivity() {
        val login = editTextLogin?.text?.toString()
        val password = editTextPassword?.text?.toString()
        startActivityForResult(
                Intent(this, ActivitySecond::class.java).apply {
                    putExtra("Логин", login)
                    putExtra("Пароль", password)
                }, REQUEST_CODE_RESULT
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_CODE_RESULT -> {
                Toast.makeText(
                        this,
                        data?.getStringExtra(KEY_PERSONS_NAME),
                        Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}