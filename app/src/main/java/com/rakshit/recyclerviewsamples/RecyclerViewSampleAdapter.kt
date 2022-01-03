package com.rakshit.recyclerviewsamples

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.rakshit.recyclerviewsamples.utils.Fresco

/**
 * Sample Recycler View's adapter
 * @author Rakshit Nawani
 */
class RecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    private val items: ArrayList<String> = arrayListOf()

    fun addItem(item: String) {
        items.add(item)
        val insertedAt = items.size - 1
        notifyItemInserted(insertedAt)
    }

    fun clear() {
        val range = items.size
        items.clear()
        notifyItemRangeRemoved(0, range)
    }

    fun addMoreItems(item: ArrayList<String>) {
        val previousRange = items.size
        items.addAll(item)
        val newRange = items.size
        notifyItemRangeInserted(previousRange, newRange)
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_photos, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val content = items[position]

        Fresco.newBuilder(holder.itemTextView)
            .setPlaceholderImage(R.mipmap.ic_launcher)
            .withProgressBar(true)
            .setRoundCircleColor(android.R.color.white)
            .roundAsCircle(false)
            .setRoundCircleColor(R.color.purple_200)
            .setUri(Uri.parse(content))
            .build(context)

        holder.itemPosition.text = "${position + 1}"

    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val itemTextView: SimpleDraweeView = view.findViewById(R.id.sdv_photo)
    val itemPosition: TextView = view.findViewById(R.id.tv_count)
}