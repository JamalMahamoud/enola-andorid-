package com.jamalmahamoud.me.recycleview

import android.annotation.SuppressLint
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jamalmahamoud.me.R.*
import com.jamalmahamoud.me.model.Reward
import com.jamalmahamoud.me.model.StepsforPractise


class StepsAdapter(
    private val steps: List<StepsforPractise>?,
    private val viewType1: Int) : RecyclerView.Adapter<StepsAdapter.ViewHolder>()  {
    private var onClickListener: OnClickListener? = null


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(viewType1, viewGroup, false)

        return ViewHolder(view)
    }


    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val rewardModel = steps!![position]

        viewHolder.stepsTitle.text = rewardModel.title
        viewHolder.stepDec.text = rewardModel.des


        viewHolder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, rewardModel)

            }
        }

    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = steps!!.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val stepsTitle : TextView = view.findViewById(id.tv_steps_title)
        val stepDec : TextView = view.findViewById(id.tv_expandable)


        init {
            // Define click listener for the ViewHolder's View.

        }
    }

    interface OnClickListener {
        fun onClick(position: Int, model: StepsforPractise) {}

    }

}

