package com.jamalmahamoud.me.activity.parent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jamalmahamoud.me.databinding.ActivityChildAddBinding
import com.jamalmahamoud.me.databinding.ActivityParentPageBinding

class AddChildActivity : AppCompatActivity(){

    lateinit var binding : ActivityChildAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChildAddBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}