package com.example.esiea3a.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3a.R
import com.example.esiea3a.presentation.api.ColorListResponse

class ColorAdaptater(private var dataSet: List<ColorListResponse>, var listener: ((Int) -> Unit)? = null) : RecyclerView.Adapter<ColorAdaptater.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.color_name)
        }
    }

    fun updateList(list: List<ColorListResponse>){
        dataSet = list
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.color_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val colorListResponse : com.example.esiea3a.presentation.api.ColorListResponse = dataSet[position]
        viewHolder.textView.text = colorListResponse.title
        viewHolder.itemView.setOnClickListener{
            listener?.invoke(position)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}