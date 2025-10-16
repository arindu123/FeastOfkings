package com.example.revix

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.cardview.widget.CardView

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)

        // Insets handling
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        updateUsername()

        // Profile image click listener
        val profileImage: ImageView = findViewById(R.id.profileImage)
        profileImage.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        // Notification icon
        val notificationIcon: ImageView = findViewById(R.id.nvector)
        notificationIcon.setOnClickListener {
            // Implement notification logic
        }

        // Food cards
        val hamburgerCard: CardView = findViewById(R.id.hamburgerCard)
        hamburgerCard.setOnClickListener {
            val intent = Intent(this, Burger_One::class.java)
            startActivity(intent)
        }

        // Add to cart example
        val addButton1: CardView = findViewById(R.id.addButton1)
        addButton1.setOnClickListener {
            addToCart("Hamburger", 7.00)
        }

        // Categories
        val categoryAll: CardView = findViewById(R.id.categoryAll)
        categoryAll.setOnClickListener { filterByCategory("all") }

        val categoryPizza: CardView = findViewById(R.id.categoryPizza)
        categoryPizza.setOnClickListener { filterByCategory("pizza") }

        val categoryBurger: CardView = findViewById(R.id.categoryBurger)
        categoryBurger.setOnClickListener { filterByCategory("burger") }

        val categorySandwich: CardView = findViewById(R.id.categorySandwich)
        categorySandwich.setOnClickListener { filterByCategory("sandwich") }

        // Bottom nav setup
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val homeIcon: ImageView = findViewById(R.id.homeicon)
        val searchIcon: ImageView = findViewById(R.id.searchicon1)
        val profileIcon: ImageView = findViewById(R.id.profileicon)
        val cartIcon: ImageView = findViewById(R.id.cartIcon)

        homeIcon.setOnClickListener {
            // Already in home, do nothing
        }

        // Uncomment if you create SearchActivity
        // searchIcon.setOnClickListener {
        //     val intent = Intent(this, SearchActivity::class.java)
        //     startActivity(intent)
        // }

        profileIcon.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        cartIcon.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
    }

    private fun addToCart(itemName: String, price: Double) {
        // TODO: Implement add to cart functionality
        // Example: Save to SharedPreferences or database
        // Toast.makeText(this, "$itemName added to cart for $${String.format("%.2f", price)}", Toast.LENGTH_SHORT).show()
    }

    private fun filterByCategory(category: String) {
        // TODO: Implement category filtering logic
        updateCategorySelection(category)
    }

    private fun updateCategorySelection(selectedCategory: String) {
        val categoryAll: CardView = findViewById(R.id.categoryAll)
        val categoryPizza: CardView = findViewById(R.id.categoryPizza)
        val categoryBurger: CardView = findViewById(R.id.categoryBurger)
        val categorySandwich: CardView = findViewById(R.id.categorySandwich)

        // TODO: Change background/text colors based on selectedCategory
    }

    private fun updateUsername() {
        val username = intent.getStringExtra("username") ?: "Guest"
        // Username variable available for logic if needed
        // Currently not displayed in UI
    }
}
