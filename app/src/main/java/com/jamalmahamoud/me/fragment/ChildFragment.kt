package com.jamalmahamoud.me.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jamalmahamoud.me.R
import com.jamalmahamoud.me.databinding.FragmentChildBinding
import com.jamalmahamoud.me.MeeSystem
import com.jamalmahamoud.me.recycleview.CheckinsAdapter


class ChildFragment : Fragment() {
    lateinit var binding : FragmentChildBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentChildBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerview: RecyclerView = binding.recentCheckinsRecyclerview
        recyclerview.layoutManager = LinearLayoutManager(context)
        val adapter =
            CheckinsAdapter(MeeSystem.getCheckings(), R.layout.checkins_list)
        recyclerview.adapter = adapter



}



}