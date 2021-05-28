package com.example.appcar.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appcar.R
import com.example.appcar.data.model.Road

class ItemMapRoadAdapter(
    private var viewType: Int,
    private var listRoad: List<Road>,
    private val listener: (Road) -> Unit,
    private val loveListener: (Road) -> Unit
) : RecyclerView.Adapter<ItemMapRoadAdapter.ItemMapViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMapViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_map_info, parent, false)
        return ItemMapViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemMapViewHolder, position: Int) {
        holder.onBindView(listRoad[position])
        holder.itemView.setOnClickListener {
            listener(listRoad[position])
        }
        holder.iconLove.setOnClickListener {
            val road = listRoad[position]
            loveListener(road)
            if (road.isFavorite) {
                holder.iconLove.setImageResource(R.drawable.ic_favorite_24_selected)
            } else {
                holder.iconLove.setImageResource(R.drawable.ic__favorite_24_unselect)
            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }
    override fun getItemCount(): Int {
        return listRoad.size
    }


    class ItemMapViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.titleItemMap)
        var description: TextView = itemView.findViewById(R.id.descriptionItemMap)
        var iconLove: ImageView = itemView.findViewById(R.id.iconFavorite)


        fun onBindView(item: Road) {
            title.text = item.name
            description.text = item.description
            if (item.isFavorite) {
                iconLove.setImageResource(R.drawable.ic_favorite_24_selected)
            } else {
                iconLove.setImageResource(R.drawable.ic__favorite_24_unselect)
            }
        }

    }


    fun updateList(data: List<Road>) {
        listRoad = data
        notifyDataSetChanged()
    }

    companion object {
        const val VIEW_TYPE_MAP = 1
        const val VIEW_TYPE_LIST = 2
    }
}

