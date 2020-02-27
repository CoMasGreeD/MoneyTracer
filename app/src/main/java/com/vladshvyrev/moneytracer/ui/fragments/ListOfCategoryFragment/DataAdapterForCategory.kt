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


class DataAdapterForCategory(val clickListener: (ItemForCategory) -> Unit): RecyclerView.Adapter<DataAdapterForCategory.BlogViewHolder>() {
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
        holder.bind(items[position],clickListener)
    }
    fun submitList(blogList: List<ItemForCategory>){

        for( item in blogList) {
            if(item.category != null)
                items.add(item)
        }
        notifyDataSetChanged()
    }
    class BlogViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        private var textId: Int = 0
        private val textName = itemView.category_name
        private val textIncome = itemView.income

        fun bind(data: ItemForCategory,clickListener: (ItemForCategory) -> Unit) {
            itemView.setOnClickListener{
                clickListener(data)
            }
            textIncome.text = data.income_or_not
            textName.text = data.category
            textId=data.id
        }
    }
}