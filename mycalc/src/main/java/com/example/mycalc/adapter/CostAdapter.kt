package com.example.mycalc.adapter

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mycalc.R
import com.example.mycalc.bean.CostBean

class CostAdapter internal constructor()
    : ListAdapter<CostBean, CostAdapter.CostViewHolder>(AsyncDifferConfig.Builder<CostBean>(object : DiffUtil.ItemCallback<CostBean?>() {

//    var costClickCallBack: CostClickCallBack = costClickCallBack;

    override fun areItemsTheSame(oldItem: CostBean, newItem: CostBean): Boolean {
        return oldItem.id === newItem.id;
    }

    override fun areContentsTheSame(oldItem: CostBean, newItem: CostBean): Boolean {
        return oldItem.id === newItem.id;
    }
}).build()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CostViewHolder {
        val from = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false);
        return CostViewHolder(from, null);
    }

    override fun onBindViewHolder(holder: CostViewHolder, position: Int) {
        var tv = holder.itemView.findViewById<TextView>(R.id.tv);
        tv.text = getItem(position).text;
    }

    class CostViewHolder(itemView: View, costClickCallBack: CostClickCallBack?) : RecyclerView.ViewHolder(itemView) {

        init {

        }
    }
}




