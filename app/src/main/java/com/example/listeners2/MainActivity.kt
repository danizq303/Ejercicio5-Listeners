package com.example.listeners2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.listeners2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextTextPersonName.setOnFocusChangeListener { _, b ->
            if (b) {
                binding.textView.text = "Primer EditText"
            }
        }

        binding.editTextTextPersonName2.setOnFocusChangeListener { _, b ->
            if (b) {
                binding.textView.text = "Segundo EditText"
            }
        }

        binding.editTextTextPersonName.addTextChangedListener {
            if (it!!.isNotEmpty())
                binding.button.isEnabled = binding.editTextTextPersonName2.text.isNotEmpty()
            else
                binding.button.isEnabled = false
        }

        binding.editTextTextPersonName2.addTextChangedListener {
            if (it!!.isNotEmpty())
                binding.button.isEnabled = binding.editTextTextPersonName.text.isNotEmpty()
            else
                binding.button.isEnabled = false
        }

        binding.button.setOnClickListener {
            binding.editTextTextPersonName.setText("%s %s".format(binding.editTextTextPersonName.text, binding.editTextTextPersonName2.text))
            binding.editTextTextPersonName2.setText("")
        }
    }

}