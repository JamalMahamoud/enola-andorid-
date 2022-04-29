package com.jamalmahamoud.me.activity.parent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.jamalmahamoud.me.R

import com.jamalmahamoud.me.databinding.FragmentSetGoalsBinding

class SetGoalFragment : Fragment() {

    lateinit var binding: FragmentSetGoalsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSetGoalsBinding.inflate(inflater,container,false)
        return binding.root
    }
}