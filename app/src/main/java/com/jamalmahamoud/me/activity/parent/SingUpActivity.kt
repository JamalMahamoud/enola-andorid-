package com.jamalmahamoud.me.activity.parent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jamalmahamoud.me.R
import com.jamalmahamoud.me.databinding.ActivitySingUpBinding

class SingUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySingUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySingUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnGetSingup.setOnClickListener {
                intent = Intent(this,ParentPageActivity::class.java)
                startActivity(intent)
        }
    }
}