package com.mateo.ejercicio1kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mateo.ejercicio1kotlin.databinding.ActivityMainBinding
import com.mateo.ejercicio1kotlin.databinding.ActivityPublishBinding

class PublishActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPublishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPublishBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.publishBtn.setOnClickListener() {

            val intent = Intent().apply {
                putExtra("usernameData", binding.usernameET.text.toString())
                putExtra("statusData", binding.statusET.text.toString())
            }
            setResult(Activity.RESULT_OK, intent)
            finish()

        }
    }


}