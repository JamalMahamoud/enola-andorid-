package com.jamalmahamoud.me.activity.parent

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.commit
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.google.android.material.navigation.NavigationBarView
import com.jamalmahamoud.me.R
import com.jamalmahamoud.me.databinding.ActivityParentPageBinding
import com.jamalmahamoud.me.fragment.ChildFragment
import org.tensorflow.lite.examples.textclassification.client.Result
import kotlin.math.roundToInt

class ParentPageActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    lateinit var binding: ActivityParentPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParentPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavForParentPage.setOnItemSelectedListener(this)



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.child -> {
                supportFragmentManager.commit {
                replace(R.id.frame_container_for_parent_page, ChildFragment())
            }
                true
            }

            R.id.add_goals-> {supportFragmentManager.commit {
                replace(R.id.frame_container_for_parent_page,SetGoalFragment())
            }
                true
            }
            else -> false
        }}


        fun barchart(
            barChart: BarChart,
            arrayList: ArrayList<BarEntry>?,
            xAxisValues: ArrayList<String>?
        ) {
            barChart.setDrawBarShadow(false)
            barChart.setFitBars(true)
            barChart.setDrawValueAboveBar(true)
            barChart.setMaxVisibleValueCount(25)
            barChart.setPinchZoom(true)
            barChart.setDrawGridBackground(true)
            val barDataSet = BarDataSet(arrayList, "Class")
            barDataSet.setColors(
                *intArrayOf(
                    Color.parseColor("#03A9F4"),
                    Color.parseColor("#FF9800"),
                    Color.parseColor("#76FF03"),
                    Color.parseColor("#000000"),
                    Color.parseColor("#E91E63"),
                    Color.parseColor("#2962FF")
                )
            )
            //barDataSet.setColors(new int[]{Color.parseColor("#03A9F4"), Color.parseColor("#FF9800"), Color.parseColor("#76FF03"), Color.parseColor("#E91E63")});
            //barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            val barData = BarData(barDataSet)
            barData.barWidth = 0.5f
            barData.setValueTextSize(0.5f)
            barChart.setBackgroundColor(Color.TRANSPARENT) //set whatever color you prefer
            barChart.setDrawGridBackground(false)
            barChart.animateY(2000)

            //Legend l = barChart.getLegend(); // Customize the ledgends
            //l.setTextSize(10f);
            //l.setFormSize(10f);
//To set components of x axis
            val xAxis = barChart.xAxis
            xAxis.textSize = 18f
            xAxis.position = XAxis.XAxisPosition.TOP_INSIDE
            xAxis.valueFormatter = IndexAxisValueFormatter(xAxisValues)
            xAxis.setDrawGridLines(false)
            xAxis.setDrawAxisLine(false)
            xAxis.isEnabled = true

            /*YAxis yLeft = barChart.getAxisLeft();
            yLeft.setAxisMaximum(100f);
            yLeft.setAxisMinimum(0f);
            yLeft.setEnabled(false);*/barChart.data = barData
        }


        /** Show classification result on the screen.  */
        fun showResult(inputText: String, results: List<Result>,mBarChart : HorizontalBarChart) {
            // Run on UI thread as we'll updating our app UI
            runOnUiThread {
                val labels = ArrayList<String>()
                val BarLabel = ArrayList<String>()
                val probability = ArrayList<Float>()
                val barEntries = ArrayList<BarEntry>()
                val textToShow = "Input: $inputText\nOutput:\n"
                for (i in results.indices) {
                    val result =
                        results[i]
                    labels.add(result.title) // Extract labels
                    probability.add(result.confidence) // Extract confidence
                }
                mBarChart.setDrawBarShadow(false)
                mBarChart.setDrawValueAboveBar(true)
                mBarChart.description.isEnabled = false
                mBarChart.setPinchZoom(false)
                mBarChart.setDrawGridBackground(false)
                val xl = mBarChart!!.xAxis
                xl.position = XAxis.XAxisPosition.BOTTOM
                xl.setDrawAxisLine(true)
                xl.setDrawGridLines(false)
                xl.granularity = 1f
                val yl = mBarChart.getAxisLeft()
                yl.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART)
                yl.setDrawGridLines(false)
                yl.isEnabled = false
                yl.axisMinimum = 0f
                val yr = mBarChart.getAxisRight()
                yr.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART)
                yr.setDrawGridLines(false)
                yr.axisMinimum = 0f


                // PREPARING THE ARRAY LIST OF BAR ENTRIES
                for (i in probability.indices) {
                    barEntries.add(BarEntry(i.toFloat(), probability[i] * 100))
                }


                for (i in labels.indices) {
                    BarLabel.add(
                        ((probability[i] * 1000).roundToInt() / 10.0).toString() + "% " + labels[i]
                    )
                }

                barchart(mBarChart, barEntries, BarLabel)

            }
        }


















    }
