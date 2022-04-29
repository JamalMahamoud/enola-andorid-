package com.jamalmahamoud.me.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jamalmahamoud.me.R
import com.jamalmahamoud.me.model.Exercises
import com.jamalmahamoud.me.model.Goals


class GoalsAdapter(
    private val goals: List<Goals>?,
    private val viewType1: Int) : RecyclerView.Adapter<GoalsAdapter.ViewHolder>() {

    private var onClickListener: OnClickListener? = null


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(viewType1, viewGroup, false)

        return ViewHolder(view)
    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val goalModel = goals!![position]
        viewHolder.goalsDescription.text = goalModel.description
        viewHolder.goalsName.text =goalModel.title
        viewHolder.goalsRewardPoint.text = goalModel.rewardPoint.toString()

        viewHolder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, goalModel)
            }
        }

    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = goals!!.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val  goalsName: TextView = view.findViewById(R.id.goal_title)
        val goalsDescription: TextView = view.findViewById(R.id.goal_des)
        val  goalsRewardPoint : TextView = view.findViewById(R.id.goal_reward)



        init {
            // Define click listener for the ViewHolder's View.

        }
    }

    interface OnClickListener {
        fun onClick(position: Int, model: Goals) {}

    }

}

