package com.vladshvyrev.moneytracer.ui.fragments.AccountsFragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.vladshvyrev.moneytracer.R
import com.vladshvyrev.moneytracer.Repository.network.ItemForAccounts
import com.vladshvyrev.moneytracer.Repository.network.ItemForCategory

import kotlinx.android.synthetic.main.item_data_for_accounts.view.*


class DataAdapterForAccounts(val clickListener: (ItemForCategory) -> Unit): RecyclerView.Adapter<DataAdapterForAccounts.BlogViewHolder>() {
    private var items = mutableListOf<ItemForCategory>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_data_for_accounts, parent, false)
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
            if(item.accItem?.money != null)
                items.add(item)
        }
        notifyDataSetChanged()
    }
    class BlogViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        private var textId: Int = 0
        private val textName = itemView.account_name
        private val textMoney = itemView.account_money

        fun bind(data: ItemForCategory,clickListener: (ItemForCategory) -> Unit) {
            itemView.setOnClickListener{
                clickListener(data)
            }
            if(data.accItem?.name != null) {
                textName.text = data.accItem?.name
                if(data.accItem!!.money < 0) {
                    textMoney.text = data.accItem?.money.toString()
                    textMoney.setTextColor(ContextCompat.getColor(itemView.context,R.color.red))
                }
                else{
                    textMoney.text = data.accItem?.money.toString()
                    textMoney.setTextColor(ContextCompat.getColor(itemView.context,R.color.primary))
                }
            }
            //textId=data.id

        }
    }
}