package com.jamalmahamoud.me.activity.child

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.jamalmahamoud.me.MainActivity
import com.jamalmahamoud.me.MeeSystem
import com.jamalmahamoud.me.R
import com.jamalmahamoud.me.databinding.ActivityMainEntriesBinding
import com.jamalmahamoud.me.fragment.DiaryFragment
import com.jamalmahamoud.me.model.Entries
import java.text.SimpleDateFormat
import java.util.*

class MainEntries : AppCompatActivity() {

    lateinit var binding: ActivityMainEntriesBinding

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainEntriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentTime = Calendar.getInstance().time
        binding.tvDiaryDd.text = SimpleDateFormat("dd").format(currentTime)
        binding.tvDiaryMm.text = SimpleDateFormat("MMMM").format(currentTime)
        binding.tvDiaryDay.text = SimpleDateFormat("EEEE").format(currentTime)
        binding.time.text = SimpleDateFormat("h:mm a").format(currentTime)



        binding.btnSave.setOnClickListener {
            val title = binding.title.text.toString()
            val text = binding.text.text.toString()
            MeeSystem.addDiaries(Entries(title, Calendar.getInstance().time, text))
            startActivity(Intent(this,MainActivity::class.java))



        }




    }


}