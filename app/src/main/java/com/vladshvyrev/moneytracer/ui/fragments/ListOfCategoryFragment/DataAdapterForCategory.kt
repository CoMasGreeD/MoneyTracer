package com.vladshvyrev.moneytracer.ui.fragments.ListOfCategoryFragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vladshvyrev.moneytracer.R
import com.vladshvyrev.moneytracer.Repository.network.ItemForAccounts
import com.vladshvyrev.moneytracer.Repository.network.ItemForCategory
import kotlinx.android.synthetic.main.item_data_for_category.view.*


class DataAdapterForCategory: RecyclerView.Adapter<DataAdapterForCategory.BlogViewHolder>() {
    private var items = mutableListOf<ItemForCategory>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_data_for_category, parent, false)
        )
    }
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.bind(items[position])
    }
    fun submitList(blogList: List<ItemForCategory>){
        items.addAll(blogList)
        notifyDataSetChanged()
    }
    class BlogViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        private var textId: Int = 0
        private val textName = itemView.category_name

        fun bind(data: ItemForCategory) {
            textName.text = data.category
            textId=data.id
        }
    }
}