package com.sun.nhom5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sun.nhom5.databinding.ActivityMainBinding
import com.sun.nhom5.example.SampleActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnNavigateToSampleMVP.setOnClickListener {
            val intent = Intent(this, SampleActivity::class.java)
            startActivity(intent)
        }
    }
}
