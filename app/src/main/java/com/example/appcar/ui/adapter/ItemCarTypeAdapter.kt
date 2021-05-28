package com.example.appcar.ui.adapter


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appcar.R
import com.example.appcar.data.model.CarType
import com.example.appcar.data.model.Road

class ItemCarTypeAdapter(
    var list: List<CarType>,
    val clickListener : (Int) -> Unit
) :
    RecyclerView.Adapter<ItemCarTypeAdapter.MapCarTypeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapCarTypeViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_car_type, parent, false)
        return MapCarTypeViewHolder(view)
    }

    override fun onBindViewHolder(holder: MapCarTypeViewHolder, position: Int) {
        holder.bindView(list[position])
        holder.itemView.setOnClickListener {
            clickListener(list[position].id)
            holder.changeChoose()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MapCarTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameCarType: TextView = itemView.findViewById(R.id.nameCarType)
        var choose : Boolean = false

        fun bindView(carType: CarType) {
            nameCarType.text = carType.name

        }

        fun changeChoose(){
            if(choose){
                itemView.setBackgroundResource(R.drawable.bg_icon_type_selected)
                nameCarType.setTextColor(Color.parseColor("#D3485AFE"))
            }
            else{
                itemView.setBackgroundResource(R.drawable.bg_icon_type_unselected)
                nameCarType.setTextColor(Color.parseColor("#fff"))
            }
        }
    }

    fun updateList(data: List<CarType>) {
        list = data
        notifyDataSetChanged()
    }
}