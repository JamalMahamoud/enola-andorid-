package com.jamalmahamoud.me.activity.child

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jamalmahamoud.me.R
import com.jamalmahamoud.me.databinding.ActivityRewardBinding
import com.jamalmahamoud.me.databinding.FragmentRewardBinding

class RewardActivity : AppCompatActivity() {

    lateinit var binding : FragmentRewardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentRewardBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}