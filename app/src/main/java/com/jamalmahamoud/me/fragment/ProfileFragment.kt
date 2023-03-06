package com.jamalmahamoud.me.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jamalmahamoud.me.R
import com.jamalmahamoud.me.activity.parent.ParentPageActivity
import com.jamalmahamoud.me.databinding.FragmentRewardBinding
import com.jamalmahamoud.me.model.Reward
import com.jamalmahamoud.me.recycleview.RewardAdapter

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentRewardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRewardBinding.inflate(inflater,container,false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settingUpReward()

        binding.parent.setOnClickListener {
            startActivity(Intent(context,ParentPageActivity::class.java))
        }


    }


    private fun settingUpReward(){

        val rewardList = listOf(
            Reward(R.drawable.cinema,"Go to to cinema",4),
            Reward(R.drawable.buy_a_book,"Buy a new book",3),
            Reward(R.drawable.icecream,"Get ice Cream",4),
            Reward(R.drawable.game,"Buy a new Game",4),
        )

        binding.rewards.text = rewardList.size.toString()

        val recyclerView : RecyclerView = binding.recyclerviewReward
        recyclerView.layoutManager =
            LinearLayoutManager(context)
        val adapter = RewardAdapter(rewardList,R.layout.reward_list)
        recyclerView.adapter = adapter

    }







}