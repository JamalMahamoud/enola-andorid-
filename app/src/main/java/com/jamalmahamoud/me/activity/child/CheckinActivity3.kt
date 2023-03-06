package com.jamalmahamoud.me.activity.child


import android.content.Intent

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


import com.jamalmahamoud.me.MainActivity
import com.jamalmahamoud.me.databinding.FragmentCheckinPartTwoBinding
import com.jamalmahamoud.me.model.Checkins
import com.jamalmahamoud.me.MeeSystem

import org.tensorflow.lite.examples.textclassification.client.Result
import org.tensorflow.lite.examples.textclassification.client.TextClassificationClient


class CheckinActivity3 : AppCompatActivity() {

    lateinit var binding: FragmentCheckinPartTwoBinding
    private val TAG = "TextClassificationDemo"
    private var checkins :Checkins? = null





    private var client: TextClassificationClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCheckinPartTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)



       checkins =  intent.getSerializableExtra("checkins") as Checkins
        client = TextClassificationClient(applicationContext)




        binding.buttonNext.setOnClickListener {
            checkins!!.feelings = binding.emotionalText.text.toString()
            classify(binding.emotionalText.text.toString())
            MeeSystem.checkins.add(checkins!!)
            startActivity(Intent(this, MainActivity::class.java))
        }
    }





    private fun classify(text: String) {
        Handler(Looper.getMainLooper()).post {
            // Run text classification with TF Lite.
            val results = client!!.classify(text)

            // Show classification result on screen
            showResult(text, results)
            checkins!!.result = results

        }
    }


    private fun showResult(inputText: String, results: List<Result>) {
        // Run on UI thread as we'll updating our app UI
        runOnUiThread {
            var textToShow = "Input:  $inputText\nOutput:\n"
            for (i in results.indices) {
                val result =
                    results[i]
                textToShow += String.format(
                    "    %s: %s\n",
                    result.title,
                    result.confidence
                )
            }
            textToShow += "---------\n"

            // Append the result to the UI.


            // Append the result to the UI.


        }
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG, "onStart")
        Handler(Looper.getMainLooper()).post(
            Runnable { client!!.load() })
    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG, "onStop")
        Handler(Looper.getMainLooper()).post(
            Runnable { client!!.unload() })
    }










}