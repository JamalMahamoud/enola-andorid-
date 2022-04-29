package com.jamalmahamoud.me.recycleview

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.jamalmahamoud.me.R
import com.jamalmahamoud.me.R.*
import com.jamalmahamoud.me.model.Goals
import com.jamalmahamoud.me.model.StepsforPractise


class StepsPracticeAdapter(
    private val steps: List<StepsforPractise>?,
    private val viewType1: Int)
    : RecyclerView.Adapter<StepsPracticeAdapter.ViewHolder>()  {

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
        val stepsModel = steps!![position]
        viewHolder.stepsDescription.text = stepsModel.des
        viewHolder.stepsTitle.text = stepsModel.title
        viewHolder.stepsTime.text ="${stepsModel.time} X "

        viewHolder.playButton.setOnClickListener {
            onClickListener!!.onClick(position, stepsModel,viewHolder)
            Log.i("adapter","clickedd" )
        }

        viewHolder.itemView.setOnClickListener {

            if (onClickListener != null) {
                onClickListener!!.onClick(position, stepsModel, viewHolder)


            }
        }

    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = steps!!.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val  stepsTitle: TextView = view.findViewById(id.tv_steps_title)
        val stepsDescription: TextView = view.findViewById(id.tv_expandable)
        val  stepsTime : TextView = view.findViewById(id.tv_times)
        val cardViewSteps: CardView = view.findViewById(id.card_view_steps)
        val firsLine: View = view.findViewById(id.firs_line)
        val secondLine: View = view.findViewById(id.second_line)
        val stepsDidIt: TextView = view.findViewById(id.did_it)
        val playButton : ImageView =  view.findViewById(id.play_button)
        val blinkLayout : View = view.findViewById(id.blink_color)

    }

    interface OnClickListener {
        fun onClick(position: Int, model: StepsforPractise, view: ViewHolder) {}

    }

}

