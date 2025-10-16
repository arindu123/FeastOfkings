package com.example.revix

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_paymnet)

        // Handle window insets for full screen
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.header_section)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Match Button in XML
        val payNowBtn: Button = findViewById(R.id.btnPayNow)

        // Get passed total price (if any) and show in order summary or delivery section
        val totalPrice = intent.getDoubleExtra("totalPrice", 0.0)
        // For example, append total to delivery time
        val deliveryTimeText: TextView = findViewById(R.id.tv_delivery_time)
        deliveryTimeText.text = "40 mins | Rs. ${"%.2f".format(totalPrice)}"

        payNowBtn.setOnClickListener {
            // Here just show success, since no card fields exist in layout
            val intent = Intent(this, success::class.java)
            startActivity(intent)
            showPopup("Payment Successful!", isSuccess = true)
        }
    }

    // Show a popup notification
    private fun showPopup(message: String, isSuccess: Boolean) {
        val builder = android.app.AlertDialog.Builder(this)
        builder.setMessage(message)
            .setCancelable(false)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }

        if (isSuccess) {
            builder.setTitle("Payment Successful")
        } else {
            builder.setTitle("Error")
        }

        builder.create().show()
    }
}
