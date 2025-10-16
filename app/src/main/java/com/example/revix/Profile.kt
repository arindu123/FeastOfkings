package com.example.revix

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        // Apply window insets (status/nav bar padding)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get username from intent
        val username = intent.getStringExtra("USERNAME") ?: "Semal Amarajewa"

        // Update the full name field with the username
        val fullNameEditText: EditText = findViewById(R.id.et_full_name)
        fullNameEditText.setText(username)

        // Back button
        val backButton: ImageView = findViewById(R.id.btn_back)
        backButton.setOnClickListener {
            finish() // Go back to previous activity
        }

        // Edit profile picture button
        val editProfileButton: ImageView = findViewById(R.id.btn_edit_profile)
        editProfileButton.setOnClickListener {
            // TODO: Add functionality to edit profile picture (open gallery/camera)
        }

        // Update profile button
        val updateProfileButton: MaterialButton = findViewById(R.id.btn_update_profile)
        updateProfileButton.setOnClickListener {
            val updatedName = fullNameEditText.text.toString()
            val updatedEmail = findViewById<EditText>(R.id.et_email).text.toString()
            val updatedPhone = findViewById<EditText>(R.id.et_phone_number).text.toString()
            val updatedDob = findViewById<EditText>(R.id.et_date_of_birth).text.toString()

            // TODO: Add validation + save logic (DB / SharedPreferences / API)
        }

        // 🔽 Bottom Navigation
        val homeIcon: ImageView = findViewById(R.id.homeicon)
        val searchIcon: ImageView = findViewById(R.id.searchicon1)
        val profileIcon: ImageView = findViewById(R.id.profileicon)
        val cartIcon: ImageView = findViewById(R.id.cartIcon)

        // 🏠 Home Navigation
        homeIcon.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            finish() // Optional: close Profile
        }

        // 🔍 Search Navigation
        searchIcon.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            finish()
        }

        // 👤 Profile Navigation
        profileIcon.setOnClickListener {
            // Already on Profile → do nothing
        }

        // 🛒 Cart Navigation
        cartIcon.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
