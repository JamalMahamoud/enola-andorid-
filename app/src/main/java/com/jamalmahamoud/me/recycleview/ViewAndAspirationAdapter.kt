package com.jamalmahamoud.me.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jamalmahamoud.me.R
import com.jamalmahamoud.me.model.ViewsAndAspirations


class ViewAndAspirationAdapter(private val viewAndAspirations :List<ViewsAndAspirations>, private val viewType1: Int) :
    RecyclerView.Adapter<ViewAndAspirationAdapter.ViewHolder>() {

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
        val viewAndAspirationModel = viewAndAspirations[position]
        viewHolder.viewsImage.setImageResource(viewAndAspirationModel.img)
        viewHolder.viewsName.text = viewAndAspirationModel.title


        viewHolder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position,viewAndAspirationModel)
            }
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = viewAndAspirations.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val  viewsName: TextView = view.findViewById(R.id.text_views_title)
        val  viewsImage: ImageView = view.findViewById(R.id.image_views)



        init {
            // Define click listener for the ViewHolder's View.

        }
    }

    interface OnClickListener {
        fun onClick(position: Int, model: ViewsAndAspirations) {}

    }

}

