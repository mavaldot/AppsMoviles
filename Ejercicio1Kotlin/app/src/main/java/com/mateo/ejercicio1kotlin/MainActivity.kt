package com.mateo.ejercicio1kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mateo.ejercicio1kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var layoutManager : LinearLayoutManager
    private lateinit var adapter : PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var postRecycler = binding.postRecyclerView

        layoutManager = LinearLayoutManager(this)
        postRecycler.layoutManager = layoutManager
        postRecycler.setHasFixedSize(true)

        adapter = PostAdapter()
        postRecycler.adapter = adapter

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val usernameData = result.data?.getStringExtra("usernameData")
                val statusData = result.data?.getStringExtra("statusData")
                val username = usernameData ?: "Anonymous"
                val status = statusData ?: "."

                val post = Post(username, status)

                adapter.addPost(post)
                Snackbar.make(binding.root,"${usernameData}, ${statusData}",Snackbar.LENGTH_LONG).show()
            }
            else if (result.resultCode == Activity.RESULT_CANCELED) {
                // do nothing
            }
        }

        binding.floatingBtn.setOnClickListener {

            val intent = Intent(this, PublishActivity::class.java)

            launcher.launch(intent)

        }

    }


}