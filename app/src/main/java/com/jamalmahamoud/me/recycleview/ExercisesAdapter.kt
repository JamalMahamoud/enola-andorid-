package com.jamalmahamoud.me.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jamalmahamoud.me.R
import com.jamalmahamoud.me.model.Exercises



class ExercisesAdapter(private val exercisesAndGoal: List<Exercises>, private val viewType1: Int) :
    RecyclerView.Adapter<ExercisesAdapter.ViewHolder>() {

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
        val exercisesAndGoalModel = exercisesAndGoal[position]
        viewHolder.exercisesImage.setImageResource(exercisesAndGoalModel.img)
        viewHolder.exercisesName.text = exercisesAndGoalModel.title



        viewHolder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, exercisesAndGoalModel)
            }
        }

    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = exercisesAndGoal.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val  exercisesName: TextView = view.findViewById(R.id.text_view_Exercises_and_Goals_title)
        val  exercisesImage: ImageView = view.findViewById(R.id.img_Exercises_and_Goals)



        init {
            // Define click listener for the ViewHolder's View.

        }
    }

    interface OnClickListener {
        fun onClick(position: Int, model: Exercises) {}

    }

}

