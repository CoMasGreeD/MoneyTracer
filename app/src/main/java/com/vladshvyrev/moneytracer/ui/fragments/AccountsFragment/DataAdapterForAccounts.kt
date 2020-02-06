package com.vladshvyrev.moneytracer.ui.fragments.AccountsFragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vladshvyrev.moneytracer.R
import com.vladshvyrev.moneytracer.Repository.network.ItemForAccounts

import kotlinx.android.synthetic.main.item_data_for_accounts.view.*


class DataAdapterForAccounts: RecyclerView.Adapter<DataAdapterForAccounts.BlogViewHolder>() {
    private var items = mutableListOf<ItemForAccounts>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_data_for_accounts, parent, false)
        )
    }
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.bind(items[position])
    }
    fun submitList(blogList: List<ItemForAccounts>){
        items.addAll(blogList)
        notifyDataSetChanged()
    }
    class BlogViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        private var textId: Int = 0
        private val textName = itemView.account_name
        private val textMoney = itemView.account_money
        @SuppressLint("ResourceAsColor")
        fun bind(data: ItemForAccounts) {
            textName.text = data.name
            textId=data.id
            if(data.money < 0) {
                textMoney.text = data.money.toString()
                textMoney.setTextColor(R.color.red)
            }
            else{
                textMoney.text = data.money.toString()
                textMoney.setTextColor(R.color.primary)
            }
        }
    }
}