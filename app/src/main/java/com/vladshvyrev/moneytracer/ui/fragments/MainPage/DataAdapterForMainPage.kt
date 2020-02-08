package com.vladshvyrev.moneytracer.ui.fragments.MainPage

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.vladshvyrev.moneytracer.R
import com.vladshvyrev.moneytracer.Repository.network.ItemForListTransaction
import kotlinx.android.synthetic.main.item_data_for_main_page.view.*

class DataAdapterForMainPage: RecyclerView.Adapter<DataAdapterForMainPage.BlogViewHolder>() {
    private var items = mutableListOf<ItemForListTransaction>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_data_for_main_page, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

     override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
                holder.bind(items[position])


    }
    fun submitList(blogList: List<ItemForListTransaction>?){
        items.addAll(blogList!!)
        notifyDataSetChanged()
    }
    class BlogViewHolder constructor(
        itemView: View
    ):RecyclerView.ViewHolder(itemView){
        private var textId: Int = 0
        private var dateTime =itemView.item_date
        private val textName = itemView.item_name
        private val textCategory = itemView.item_category
        private val textMoney = itemView.item_money
        private val plusOrMinus = itemView.item_plus_or_minus

        fun bind(data: ItemForListTransaction) {
            dateTime.text=data.date.toString()
            textName.text = data.name
            textCategory.text = data.category
            textId=data.id
            if(data.income == "-") {
                plusOrMinus.text = data.income
                plusOrMinus.setTextColor(ContextCompat.getColor(itemView.context, R.color.red))
                textMoney.text = data.money.toString()
                textMoney.setTextColor(ContextCompat.getColor(itemView.context, R.color.red))
            }
            else{
                plusOrMinus.text = data.income
                plusOrMinus.setTextColor(ContextCompat.getColor(itemView.context,R.color.primary))
                textMoney.text = data.money.toString()
                textMoney.setTextColor(ContextCompat.getColor(itemView.context,R.color.primary))
            }
        }
    }
}