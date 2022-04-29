package com.jamalmahamoud.me.fragment
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jamalmahamoud.me.R

import com.jamalmahamoud.me.activity.child.CheckInActivity2

import com.jamalmahamoud.me.databinding.FragmentCheckInBinding
import com.jamalmahamoud.me.model.Emotions


class CheckinsFragment : Fragment() {


    lateinit var binding: FragmentCheckInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCheckInBinding.inflate(inflater,container,false)
       return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val checkInImg = listOf(R.drawable.greatingimg2,
            R.drawable.greatingimg3,R.drawable.greatingimg4,R.drawable.greatingimg5,
            R.drawable.greatingimg6,R.drawable.greatingimg6,
            R.drawable.greatingimg8,R.drawable.greatingimg10,
            R.drawable.greatingimg12,)

        binding.checkingEmotionImg.setImageResource (checkInImg.random())


        onClickListenerOnEmotionsButtons()


    }

    private fun onClickListenerOnEmotionsButtons() {
        binding.btnHappy.setOnClickListener {
            val happy = Emotions("Happy", R.color.pink, R.drawable.happyimg)
            val intent = Intent(context, CheckInActivity2::class.java)
            intent.putExtra("happy", happy)
            startActivity(intent)

        }

        binding.btnAngry.setOnClickListener {
            val angry = Emotions("Angry", R.color.black, R.drawable.angryimg)
            val intent = Intent(context, CheckInActivity2::class.java)
            intent.putExtra("angry", angry)
            startActivity(intent)
        }

        binding.btnExcited.setOnClickListener {
            val excited = Emotions("Excited", R.color.teal_700, R.drawable.excided)
            val intent = Intent(context, CheckInActivity2::class.java)
            intent.putExtra("excited", excited)
            startActivity(intent)
        }

        binding.btnSad.setOnClickListener {
            val sad = Emotions("Sad", R.color.red, R.drawable.sadimg)
            val intent = Intent(context, CheckInActivity2::class.java)
            intent.putExtra("sad", sad)
            startActivity(intent)
        }
    }


}