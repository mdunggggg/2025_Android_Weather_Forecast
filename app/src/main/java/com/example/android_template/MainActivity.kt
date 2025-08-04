package com.example.android_template

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_template.databinding.ActivityMainBinding
import com.example.android_template.example.SampleActivity

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
