package com.jamalmahamoud.me.recycleview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.HorizontalBarChart
import com.jamalmahamoud.me.R
import com.jamalmahamoud.me.activity.parent.ParentPageActivity
import com.jamalmahamoud.me.model.Checkins
import java.text.SimpleDateFormat
import java.util.*


class CheckinsAdapter(
    private val checkins: List<Checkins>?,
    private val viewType1: Int) : RecyclerView.Adapter<CheckinsAdapter.ViewHolder>() {

    private var onClickListener: OnClickListener? = null


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(viewType1, viewGroup, false)

        return ViewHolder(view)
    }


    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val checkinsModel = checkins!![position]


        val currentdate = checkinsModel.date
        viewHolder.checkinsText.text = checkinsModel.feelings
        viewHolder.checkinsDD.text = SimpleDateFormat("DD").format(currentdate)
        viewHolder.checkinsMM.text = SimpleDateFormat("MMMM").format(currentdate)
        viewHolder.checkinsDay.text = SimpleDateFormat("EEEE").format(currentdate)
        viewHolder.checkinsTime.text = SimpleDateFormat("h:mm a").format(currentdate)
        viewHolder.checkinsText.text =checkinsModel.feelings
         val mBarChart = viewHolder.checkins
        ParentPageActivity().showResult("", checkinsModel.result!!,mBarChart)
        viewHolder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, checkinsModel)
            }
        }

    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = checkins!!.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val  checkinsDD: TextView = view.findViewById(R.id.tv_progress_dd)
        val  checkinsMM: TextView = view.findViewById(R.id.progress_mm)
        val  checkinsDay: TextView = view.findViewById(R.id.tv_progress_day)
        val  checkinsTime: TextView = view.findViewById(R.id.progress_time)
        val  checkinsText: TextView = view.findViewById(R.id.progress_entries)
        val  checkins: HorizontalBarChart = view.findViewById(R.id.progress_chart)






        init {
            // Define click listener for the ViewHolder's View.

        }
    }

    interface OnClickListener {
        fun onClick(position: Int, model: Checkins) {}

    }

}

