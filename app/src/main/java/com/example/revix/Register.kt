package com.example.revix

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.revix.LoginPage
import com.example.revix.R
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textfield.TextInputEditText

class Register : AppCompatActivity() {

    private lateinit var fullNameEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var mobileEditText: TextInputEditText
    private lateinit var signUpButtonCard: MaterialCardView
    private lateinit var loginTab: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        window.statusBarColor = getColor(R.color.status_bar_yellow)


        // Initialize views
        fullNameEditText = findViewById(R.id.fullNameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        mobileEditText = findViewById(R.id.mobileEditText)
        signUpButtonCard = findViewById(R.id.signUpButtonCard)
        loginTab = findViewById(R.id.loginTab)

        // Sign Up button click
        signUpButtonCard.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
            registerUser()
        }

        // Already have account → navigate to Login
        loginTab.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }
    }

    private fun registerUser() {
        val name = fullNameEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()
        val mobile = mobileEditText.text.toString().trim()

        // Validate fields
        if (name.isEmpty()) {
            fullNameEditText.error = "Enter full name"
            return
        }
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.error = "Enter valid email"
            return
        }
        if (password.length < 6) {
            passwordEditText.error = "Password must be at least 6 characters"
            return
        }
        if (mobile.length < 10) {
            mobileEditText.error = "Enter valid mobile number"
            return
        }

        // If all checks pass
        Toast.makeText(this, "Registered Successfully 🎉", Toast.LENGTH_LONG).show()

    }
}
