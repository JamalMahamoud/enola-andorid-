package com.jamalmahamoud.me

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.commit
import com.google.android.material.navigation.NavigationBarView
import com.jamalmahamoud.me.activity.parent.GetStartedActivity
import com.jamalmahamoud.me.databinding.ActivityMainBinding
import com.jamalmahamoud.me.fragment.ProfileFragment
import com.jamalmahamoud.me.fragment.CheckinsFragment
import com.jamalmahamoud.me.fragment.DiaryFragment
import com.jamalmahamoud.me.fragment.HomeFragment

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        intent = Intent(this,GetStartedActivity::class.java)
//        startActivity(intent)

        binding.bottomNav.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.icon_home -> {
                supportFragmentManager.commit {
                    replace(R.id.frame_container, HomeFragment())
                }
                true

            }
            R.id.icon_alert ->{
                supportFragmentManager.commit {
                    replace(R.id.frame_container, ProfileFragment())}
                true
            }
            R.id.icon_chick_in-> {
                supportFragmentManager.commit {
                    replace(R.id.frame_container, CheckinsFragment())}
                true
            }

            R.id.icon_diary-> {
                supportFragmentManager.commit {
                    replace(R.id.frame_container, DiaryFragment())}
                true
            }


            else -> false

        }
    }


}