package com.jamalmahamoud.me.activity.child

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jamalmahamoud.me.R
import com.jamalmahamoud.me.databinding.ActivityPractiseWithMeBinding
import com.jamalmahamoud.me.model.Goals
import com.jamalmahamoud.me.model.StepsforPractise
import com.jamalmahamoud.me.recycleview.StepsPracticeAdapter


class PractiseWithMeActivity : AppCompatActivity() {

    lateinit var binding: ActivityPractiseWithMeBinding
    private var goal: Goals? = null
    private var simpleVideoView : VideoView? = null
    private var mediaController : MediaController? = null
    private var video : Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPractiseWithMeBinding.inflate(layoutInflater)
        setContentView(binding.root)



        simpleVideoView = binding.VideoViewGoalSteps
        goal = intent.getSerializableExtra("goal") as Goals

        if(goal?.practiseVideo != null){ video  = goal?.practiseVideo
            settingUpVideoViews()}

        val adapter = settingUpStepsPracticeAdapter()

        settingUpOnClickListenerForSteps(adapter)

    }

    private fun settingUpStepsPracticeAdapter(): StepsPracticeAdapter {
        val recyclerview: RecyclerView = binding.listViewListOfStepForGoals
        recyclerview.layoutManager =
            LinearLayoutManager(this)
        val adapter = StepsPracticeAdapter(goal!!.steps, R.layout.practise_list)
        recyclerview.adapter = adapter
        return adapter
    }


    private fun settingUpOnClickListenerForSteps(adapter: StepsPracticeAdapter) {
        adapter.setOnClickListener(object : StepsPracticeAdapter.OnClickListener {
            override fun onClick(
                position: Int,
                model: StepsforPractise,
                view: StepsPracticeAdapter.ViewHolder

            ) {

                if (model.video != null ){
                    video = model.video
                    settingUpVideoViews()
                }




                if (view.stepsDescription.isVisible) {
                    view.stepsDescription.isVisible = false

                } else{
                    view.stepsDescription.isVisible = true
                    expandingStepView(view,model)
                }


            }

        })


    }


    private fun expandingStepView(view: StepsPracticeAdapter.ViewHolder,model : StepsforPractise) {
        view.stepsDescription.isVisible = true
        view.cardViewSteps.setCardBackgroundColor(ContextCompat.getColor(this, R.color.red))
        val blackColor = ContextCompat.getColor(this, R.color.white)
        view.stepsTitle.setTextColor(blackColor)
        view.stepsDescription.setTextColor(blackColor)
        view.stepsTime.setTextColor(blackColor)
        view.firsLine.setBackgroundColor(blackColor)
        view.secondLine.setBackgroundColor(blackColor)
        view.playButton.isVisible = false
        view.stepsDidIt.isVisible = true


        val anim = ObjectAnimator.ofInt(
            view.cardViewSteps, "CardBackgroundColor",
            ContextCompat.getColor(this, R.color.red),
            ContextCompat.getColor(this, R.color.pink),
            ContextCompat.getColor(this, R.color.red2),
        )
        anim.duration = 1500
        anim.setEvaluator(ArgbEvaluator())
        anim.repeatMode = ValueAnimator.REVERSE
        anim.repeatCount = Animation.INFINITE
        if (!model.didIt){
            anim.start()
        }

        view.stepsDidIt.setOnClickListener {
            model.didIt = true
            cancellingAnimation(view, anim)
        }

        view.playButton.setOnClickListener {
            Log.i("jj","llllll")
            if (view.stepsDescription.isVisible) {
                view.stepsDescription.isVisible = false

            } else{
                view.stepsDescription.isVisible = true
                expandingStepView(view,model)
            }
        }


    }

    private fun cancellingAnimation(
        view: StepsPracticeAdapter.ViewHolder,
        anim: ObjectAnimator) {
        view.stepsDidIt.isVisible = false
        view.playButton.setImageResource(R.drawable.ic_baseline_check_24)
        view.playButton.isVisible = true
        view.stepsDescription.isVisible = false
        anim.cancel()
        view.cardViewSteps.setCardBackgroundColor(ContextCompat.getColor(this, R.color.red))
    }

    private fun settingUpVideoViews() {
        mediaController = MediaController(this)
        simpleVideoView?.setMediaController(mediaController)
        simpleVideoView?.setVideoURI(Uri.parse("android.resource://$packageName/$video"));
        simpleVideoView?.start()
    }


}


