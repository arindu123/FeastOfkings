package com.example.revix

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Burger_One : AppCompatActivity() {

    private var quantity: Int = 1
    private val pricePerItem: Double = 7.00

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_burger_one)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.content_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get UI elements that match the XML
        val backBtn: ImageView = findViewById(R.id.btn_back)
        val favoriteBtn: ImageView = findViewById(R.id.btn_favorite)
        val titleText: TextView = findViewById(R.id.tv_title)
        val priceText: TextView = findViewById(R.id.tv_price)
        val quantityText: TextView = findViewById(R.id.tv_quantity)
        val decrementBtn: ImageView = findViewById(R.id.btn_decrease)
        val incrementBtn: ImageView = findViewById(R.id.btn_increase)
        val addToCartBtn: Button = findViewById(R.id.btn_add_to_cart)
        val detailsTab: TextView = findViewById(R.id.tab_details)
        val reviewTab: TextView = findViewById(R.id.tab_review)

        val homeIcon: ImageView = findViewById(R.id.homeicon)
        val searchIcon: ImageView = findViewById(R.id.searchicon1)
        val profileIcon: ImageView = findViewById(R.id.profileicon)
        val cartIcon: ImageView = findViewById(R.id.cartIcon)

        quantityText.text = quantity.toString()
        updatePriceDisplay(priceText)

        backBtn.setOnClickListener {
            finish()
        }

        favoriteBtn.setOnClickListener {

        }

        incrementBtn.setOnClickListener {
            quantity++
            updateQuantityAndPrice(quantityText, priceText)
        }

        decrementBtn.setOnClickListener {
            if (quantity > 1) {
                quantity--
                updateQuantityAndPrice(quantityText, priceText)
            }
        }

        addToCartBtn.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java) // Assuming you have a cart activity
            intent.putExtra("ITEM_NAME", titleText.text.toString())
            intent.putExtra("ITEM_PRICE", pricePerItem)
            intent.putExtra("QUANTITY", quantity)
            intent.putExtra("TOTAL_PRICE", pricePerItem * quantity)
            startActivity(intent)
        }

        detailsTab.setOnClickListener {
            switchToDetailsTab(detailsTab, reviewTab)
        }

        reviewTab.setOnClickListener {
            switchToReviewTab(detailsTab, reviewTab)
        }

        homeIcon.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

        searchIcon.setOnClickListener {
            val intent = Intent(this, Profile::class.java) // Assuming you have a search activity
            startActivity(intent)
        }

        profileIcon.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        cartIcon.setOnClickListener {
            val intent = Intent(this, Payment::class.java) // Assuming you have a cart activity
            startActivity(intent)
        }
    }

    //
    private fun updateQuantityAndPrice(quantityText: TextView, priceText: TextView) {
        quantityText.text = quantity.toString()
        updatePriceDisplay(priceText)
    }

    private fun updatePriceDisplay(priceText: TextView) {
        val totalPrice = pricePerItem * quantity
        priceText.text = "$ ${String.format("%.2f", totalPrice)}"
    }

    private fun switchToDetailsTab(detailsTab: TextView, reviewTab: TextView) {
        detailsTab.setBackgroundResource(R.drawable.tab_details_bg)
        detailsTab.setTextColor(resources.getColor(android.R.color.white, null))

        reviewTab.setBackgroundResource(R.drawable.rounded_edittext)
        reviewTab.setTextColor(resources.getColor(android.R.color.darker_gray, null))

    }

    private fun switchToReviewTab(detailsTab: TextView, reviewTab: TextView) {
        reviewTab.setBackgroundResource(R.drawable.tab_details_bg)
        reviewTab.setTextColor(resources.getColor(android.R.color.white, null))

        detailsTab.setBackgroundResource(R.drawable.rounded_edittext)
        detailsTab.setTextColor(resources.getColor(android.R.color.darker_gray, null))

    }
}