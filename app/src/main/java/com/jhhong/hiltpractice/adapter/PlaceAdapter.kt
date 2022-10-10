package com.jhhong.hiltpractice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jhhong.hiltpractice.data.Place
import com.jhhong.hiltpractice.databinding.ItemPlaceBinding

class PlaceAdapter : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {
    var places = mutableListOf<Place>()

    override fun getItemCount(): Int = places.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(places[position])
    }

    override fun getItemViewType(position: Int): Int {
       return position
    }

    inner class ViewHolder(binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root) {

        private val tv_index: TextView = binding.tvIndex
        private val tv_address: TextView = binding.tvAddress
        private val tv_placeName: TextView = binding.tvPlaceName

        fun bind(place: Place) {
            tv_index.text = "카페 번호 : " + place.placeIndex
            tv_address.text = "주소 : " + place.address
            tv_placeName.text = "지점명 : " + place.placeName
        }
    }
}