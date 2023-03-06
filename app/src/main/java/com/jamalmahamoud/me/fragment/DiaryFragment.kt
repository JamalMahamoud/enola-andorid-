package com.jamalmahamoud.me.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jamalmahamoud.me.MeeSystem
import com.jamalmahamoud.me.R
import com.jamalmahamoud.me.activity.child.MainEntries
import com.jamalmahamoud.me.databinding.FragmentDailryBinding
import com.jamalmahamoud.me.recycleview.EntriesAdapter
import com.jamalmahamoud.me.recycleview.ViewAndAspirationAdapter

class DiaryFragment : Fragment() {

    lateinit var binding : FragmentDailryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDailryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if (MeeSystem.diaries.size >= 2 ){
            binding.cardview1.isVisible = false
        }


        val recyclerview: RecyclerView = binding.recyclerDiary
        recyclerview.layoutManager =
            LinearLayoutManager(context)
        val adapter =
           EntriesAdapter(MeeSystem.diaries, R.layout.dairy_list)
        recyclerview.adapter = adapter



        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(context, MainEntries::class.java)
            startActivity(intent)



        }










}


}