package dk.molbak.kotlintestproject.views.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import dk.molbak.kotlintestproject.R
import dk.molbak.kotlintestproject.models.Item
import dk.molbak.kotlintestproject.views.ImageActivity
import kotlinx.android.synthetic.main.activity_image.*
import kotlinx.android.synthetic.main.item_recycler_list.view.*

class RecyclerAdapter(val items: ArrayList<Item>, val context: Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivImage = view.itemImage
        val tvName = view.itemName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler_list, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.tvName?.text = items.get(position).name
        Picasso.get().load(items.get(position).imageUrl).into(holder.ivImage)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}