package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

// Adapter for recyclerView in MainActivity . Displays affirmations data object
class ItemAdapter(private val context: Context,
                  private val dataset: List<Affirmation>
                  ): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    //provide reference to the  views for each data item
    //complex data items may need more than one view per item, and
    //we can provide access to all the views for a data item in a view holder
    //each data item is just an affirmation object
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val textView : TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    //create new views invoked by layout manager
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        //create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item,parent,false)
        return ItemViewHolder(adapterLayout)

    }

    // replace the contents of a view invoked by layout manager
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item  = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    // return the size of dataset invoked by layout manager
    override fun getItemCount() = dataset.size

}