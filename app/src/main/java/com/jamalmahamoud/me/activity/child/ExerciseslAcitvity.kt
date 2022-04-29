package com.jamalmahamoud.me.activity.child

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jamalmahamoud.me.R
import com.jamalmahamoud.me.databinding.AcitivtyTaskBinding
import com.jamalmahamoud.me.model.Exercises
import com.jamalmahamoud.me.model.Goals
import com.jamalmahamoud.me.recycleview.GoalsAdapter

class ExerciseslAcitvity : AppCompatActivity() {

     lateinit var binding: AcitivtyTaskBinding
     private var exercises :Exercises? = null
    private var listGoals : MutableList<Goals>? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AcitivtyTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)


        retrievingIntent()

        settingUpActivityWithIntent()
        }

    private fun settingUpActivityWithIntent() {
        binding.imgExercises.setImageResource(exercises!!.img)
        binding.textViewExercisesTitle.text = exercises?.title
        if (exercises?.gaols?.size == null ){
            binding.numGoals.text = "0 Goals"
            binding.tvNoGoal.text = "Ohhh nooo we have no ${exercises?.title?.lowercase()} goals for you today come back later"
            binding.noGaolsView.isVisible = true


        }
        else{
            binding.numGoals.text = "${  exercises?.gaols?.size.toString() } Goals"}


    }

    private fun retrievingIntent() {
        if (intent.hasExtra("exercise")){
            exercises = intent.getSerializableExtra("exercise") as Exercises}
        if (exercises?.gaols != null ){
            settingUpGaolsAdapter()
        }


    }


    private fun settingUpGaolsAdapter(){

        val recyclerview: RecyclerView = binding.recyclerviewGoals
        exercises?.gaols?.forEach{
            listGoals?.add(it)
        }
        recyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val adapter = GoalsAdapter(exercises!!.gaols, R.layout.goal_list)
        recyclerview.adapter = adapter
        settingUpOnClickListenerForExcAdapter(adapter)

    }


    private fun settingUpOnClickListenerForExcAdapter(adapter: GoalsAdapter) {

        adapter.setOnClickListener(object : GoalsAdapter.OnClickListener {
            override fun onClick(position: Int, model: Goals) {
                val intent = Intent(this@ExerciseslAcitvity,GoalPageActivity::class.java)
                val goal = Goals(model.title, model.description,model.steps,model.VideoURI,model.rewardPoint,model.practiseVideo)
                intent.putExtra("goal",goal)
                startActivity(intent)
            }
        })
    }





}


