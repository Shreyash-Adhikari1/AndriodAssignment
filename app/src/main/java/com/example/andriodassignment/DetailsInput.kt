package com.example.andriodassignment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.andriodassignment.databinding.ActivityDetailsInputBinding

class DetailsInput : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding: ActivityDetailsInputBinding
    val countries = arrayOf("Nepal", "India", "China", "Japan")
    val cities = arrayOf("Kathmandu", "Bhaktapur", "Lalitpur", "Kritipur", "Kanchanpur")
    var selectedCountry: String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailsInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Country Spinner
        val adapter = ArrayAdapter(
            this@DetailsInput,
            android.R.layout.simple_spinner_item,
            countries
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.countrySpinner.adapter = adapter
        binding.countrySpinner.onItemSelectedListener = this

        // City Auto Complete Text
        val autoAdapter = ArrayAdapter(
            this@DetailsInput,
            android.R.layout.simple_spinner_item,
            cities
        )
        binding.countryAutoComplete.setAdapter(autoAdapter)
        binding.countryAutoComplete.threshold = 1

        // Submit Button
        binding.submitButton.setOnClickListener {
            val name: String = binding.nameBox.text.toString()
            val email: String = binding.emailBox.text.toString()
            val password: String = binding.passwordBox.text.toString()
            val city: String = binding.countryAutoComplete.text.toString()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                binding.nameBox.error = "Name cannot be empty"
                binding.emailBox.error = "Email cannot be empty"
                binding.passwordBox.error = "Password cannot be empty"
                return@setOnClickListener
            }

            if (city.isEmpty()) {
                binding.countryAutoComplete.error = "Please select a city"
                return@setOnClickListener
            }

            // Gender Selection
            val selectedId = binding.genderRadioGroup.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, "Please select a gender!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val selectedRadioButton = findViewById<RadioButton>(selectedId)
            val gender = selectedRadioButton.text.toString()

            // Agreement Checkbox
            if (!binding.agreementCheckbox.isChecked) {
                Toast.makeText(this, "Check the box to proceed", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Pass Data to Next Activity
            val intent = Intent(this@DetailsInput, DetailsView::class.java)
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            intent.putExtra("gender", gender)
            intent.putExtra("country",selectedCountry)
            intent.putExtra("city", city)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        selectedCountry = countries[p2] // grabs the selected country
    }
    override fun onNothingSelected(p0: AdapterView<*>?) {
        selectedCountry = "" //for when nothing is selected.. the thing resets
    }
}
