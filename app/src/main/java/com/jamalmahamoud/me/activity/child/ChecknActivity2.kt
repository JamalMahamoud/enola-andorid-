package com.jamalmahamoud.me.activity.child

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.jamalmahamoud.me.databinding.ActivityCheckn2Binding
import com.jamalmahamoud.me.model.Checkins
import com.jamalmahamoud.me.model.Emotions
import java.util.*

class CheckInActivity2 : AppCompatActivity() {

    lateinit var emotion : Emotions
    private lateinit var binding: ActivityCheckn2Binding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckn2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        retrievingEmotionFromIntent()

        binding.buttonNext.setBackgroundColor(ContextCompat.getColor(this, emotion.color))
        binding.checkingEmotionImg.setImageResource(emotion.img)
        binding.textViewHowAreYou.text = "How ${emotion.title.lowercase()} are you feeling today"


        binding.buttonNext.setOnClickListener {
            val intent = Intent(this,CheckinActivity3::class.java)
           val  currentTime = Date()
            val  checkins = Checkins(currentTime,emotion,null,null,null)
                intent.putExtra("checkins",checkins)
            startActivity(intent)



        }





    }

    private fun retrievingEmotionFromIntent() {
        when {
            intent.hasExtra("excited") -> {
                emotion = intent.getSerializableExtra("excited") as Emotions
            }
            intent.hasExtra("happy") -> {
                emotion = intent.getSerializableExtra("happy") as Emotions
            }
            intent.hasExtra("sad") -> {
                emotion = intent.getSerializableExtra("sad") as Emotions
            }
            intent.hasExtra("angry") -> {
                emotion = intent.getSerializableExtra("angry") as Emotions
            }
        }
    }


}