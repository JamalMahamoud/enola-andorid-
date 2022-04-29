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
import com.jamalmahamoud.me.model.Entries
import java.text.SimpleDateFormat
import java.util.*


class EntriesAdapter(
    private val entries: List<Entries>?,
    private val viewType1: Int) : RecyclerView.Adapter<EntriesAdapter.ViewHolder>() {


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
        val entryModel = entries!![position]



        val currentdate = entryModel.date
        viewHolder.entriesText.text = entryModel.entry
        viewHolder.entriestitle.text = entryModel.title
        viewHolder.entriesDD.text = SimpleDateFormat("dd").format(currentdate)
        viewHolder.entriesMM.text = SimpleDateFormat("MMMM").format(currentdate)
        viewHolder.entriesDay.text = SimpleDateFormat("EEEE").format(currentdate)
        viewHolder.entriesTime.text = SimpleDateFormat("h:mm a").format(currentdate)

        viewHolder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, entryModel)
            }
        }

    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = entries!!.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val  entriesDD: TextView = view.findViewById(R.id.tv_diary_dd)
        val  entriesMM: TextView = view.findViewById(R.id.tv_diary_mm)
        val  entriesDay: TextView = view.findViewById(R.id.tv_diary_day)
        val  entriesTime: TextView = view.findViewById(R.id.time)
        val  entriesText: TextView = view.findViewById(R.id.entries)
        val entriestitle : TextView = view.findViewById(R.id.tv_diary_title)



        init {
            // Define click listener for the ViewHolder's View.

        }
    }

    interface OnClickListener {
        fun onClick(position: Int, model: Entries) {}

    }

}

