package com.jamalmahamoud.me.activity.parent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jamalmahamoud.me.R
import com.jamalmahamoud.me.databinding.ActivityGetStartedBinding
import com.jamalmahamoud.me.databinding.ActivityMainBinding

class GetStartedActivity : AppCompatActivity() {

    lateinit var binding: ActivityGetStartedBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnGetStarted.setOnClickListener {
            intent = Intent(this,SingUpActivity::class.java)
            startActivity(intent)

        }




    }
}