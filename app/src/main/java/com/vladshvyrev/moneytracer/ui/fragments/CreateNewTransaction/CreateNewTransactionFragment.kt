package com.vladshvyrev.moneytracer.ui.fragments.CreateNewTransaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.vladshvyrev.moneytracer.R
import com.vladshvyrev.moneytracer.Repository.network.ItemForListTransaction
import kotlinx.android.synthetic.main.fragment_add_transaction.*


class CreateNewTransactionFragment: Fragment() {
    lateinit var viewModel: CreateNewTransactionViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_transaction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CreateNewTransactionViewModel::class.java)
        viewModel.userListLiveData.observe(this,observer)
        add_but.setOnClickListener{
            var trans= ItemForListTransaction()
            trans.name = item_name.text.toString()
            trans.category=item_category.text.toString()
            trans.money=1000.0//item_money.text.toString().toDouble()
            trans.income_or_not=item_income.text.toString()
            trans.id=550//item_category.text.toString().toInt()
            trans.date = "22.02.2020"
            viewModel.postTransaction(trans)
        }

    }
    private val observer = Observer<ItemForListTransaction> { response ->
       addDataSet(response)
    }
    private fun addDataSet(data: ItemForListTransaction) {
        var trans= ItemForListTransaction()
        trans.name = data.name
        trans.category=data.category
        trans.money=data.money
        trans.income_or_not=data.income_or_not
        trans.id=data.id
    }
}