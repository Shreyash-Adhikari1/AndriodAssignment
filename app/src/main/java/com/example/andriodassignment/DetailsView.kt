package com.example.andriodassignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.andriodassignment.adapter.RecyclerAdapter
import com.example.andriodassignment.databinding.ActivityDetailsViewBinding

class DetailsView : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsViewBinding

    // Dummy Data
    private val imageList = arrayListOf(
        R.drawable.apple,
        R.drawable.grapes,
        R.drawable.mango
    )
    private val titleList = arrayListOf("Apple", "Grapes", "Mango")
    private val descList = arrayListOf("This is an apple", "These are grapes", "This is a mango")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get User Info from Intent
        val nameDisplay: String = intent.getStringExtra("name").toString()
        val emailDisplay: String = intent.getStringExtra("email").toString()
        val gender = intent.getStringExtra("gender").toString()
        val country=intent.getStringExtra("country").toString()
        val cities= intent.getStringExtra("city").toString()


        binding.nameDisplay.text = nameDisplay
        binding.emailDisplay.text = emailDisplay
        binding.genderDisplay.text=gender
        binding.countryDisplay.text=country
        binding.cityDisplay.text=cities


        // Set up RecyclerView
        binding.imageRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerAdapter(this, imageList, titleList, descList)
        binding.imageRecyclerView.adapter = adapter
    }
}
