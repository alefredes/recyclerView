package com.example.alexisfredes.recyclerviewfredes

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_item.view.*

class ItemAdapter(
    private val items: List<Item>,
    private val itemClick: (Item) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.view_item), itemClick)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.itemView) {
            item_title.text = items[position].title
            item_image.loadUrl(items[position].url)

        }
        holder.itemView.item_layout.setOnClickListener {itemClick(items[position])}
    }

    class ViewHolder(view: View, private val itemClick: (Item) -> Unit) : RecyclerView.ViewHolder(view)
}
