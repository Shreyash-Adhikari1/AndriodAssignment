package com.example.andriodassignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.andriodassignment.adapter.RecyclerAdapter
import com.example.andriodassignment.databinding.ActivityDetailsViewBinding
class DetailsView : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsViewBinding

    // Dummy Data
    private val imageList = arrayListOf(
        R.drawable.vagabond,
        R.drawable.berserk,
        R.drawable.jjk,
        R.drawable.onepiece,
        R.drawable.bleach,
        R.drawable.vinland,
        R.drawable.tokyoghoul,
        R.drawable.sakamoto,
        R.drawable.mha,
        R.drawable.naruto,
        R.drawable.dandadan
    )
    private val titleList = arrayListOf("Vagabond", "Berserk", "Jujutsu Kaisen","One Piece",
        "Bleach","Vinland Saga","Tokyo Ghoul","Sakamoto Days","My Hero Academia","Naruto",
        "Dandadan")
    private val descList = arrayListOf("Click here to read Vagabond",
        "Click here to read Vagabond",
        "Click here to read Berserk",
        "Click here to read Jujutsu Kaisen",
        "Click here to read One Piece",
        "Click here to read Bleach",
        "Click here to read Vinland Saga",
        "Click here to read Tokyo Ghoul",
        "Click here to read Sakamoto Days",
        "Click here to read My Hero Academia",
        "Click here to read Naruto",
        "Click here to read Dandadan "
    )


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

        binding.imageRecyclerView.layoutManager= GridLayoutManager(this@DetailsView,2)
    }
}

