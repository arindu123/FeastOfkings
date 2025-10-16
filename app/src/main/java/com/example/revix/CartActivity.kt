package com.example.revix

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)
        window.statusBarColor = getColor(R.color.status_bar_yellow)


        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 🔙 Back Button
        val backButton: ImageView = findViewById(R.id.btn_back)
        backButton.setOnClickListener {
            finish()
        }

        // 🛒 Checkout button
        val checkoutBtn: Button = findViewById(R.id.checkout_button) // give id in xml
        checkoutBtn.setOnClickListener {
            startActivity(Intent(this, Payment::class.java))
        }


    }
}
