package com.jamalmahamoud.me.activity.child

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jamalmahamoud.me.R
import com.jamalmahamoud.me.databinding.ActivityGoalPageBinding
import com.jamalmahamoud.me.model.Goals
import com.jamalmahamoud.me.recycleview.RewardAdapter
import com.jamalmahamoud.me.recycleview.StepsAdapter


class GoalPageActivity : AppCompatActivity() {
    lateinit var binding: ActivityGoalPageBinding
    private var goal : Goals? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityGoalPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        retreatingIntent()
        settingUpVideoViews()

        val recyclerview: RecyclerView = binding.listViewListOfStepForGoals
        recyclerview.layoutManager =
            LinearLayoutManager(this)
        val adapter = StepsAdapter(goal!!.steps,R.layout.stepslist)
        recyclerview.adapter = adapter

        buttonOnclickListener()


    }

    private fun buttonOnclickListener() {
        binding.buttonGaolComplete.setOnClickListener {
            val intent = Intent(this, PractiseWithMeActivity::class.java)
            intent.putExtra("goal",goal)
            startActivity(intent)
        }
    }

    private fun settingUpVideoViews() {
        val mediaController = MediaController(this)
        val simpleVideoView = binding.VideoViewGoalSteps
        simpleVideoView.setMediaController(mediaController)
        simpleVideoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + goal?.VideoURI));
        simpleVideoView.start()
    }

    private fun retreatingIntent(){
        if (intent.hasExtra("goal")){
           goal = intent.getSerializableExtra("goal") as Goals?
        }
    }


}