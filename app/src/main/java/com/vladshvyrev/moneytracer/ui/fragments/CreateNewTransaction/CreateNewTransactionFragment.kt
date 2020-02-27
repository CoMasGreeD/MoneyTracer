package com.vladshvyrev.moneytracer.ui.fragments.CreateNewTransaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.vladshvyrev.moneytracer.R
import com.vladshvyrev.moneytracer.Repository.network.ItemForListTransaction
import kotlinx.android.synthetic.main.fragment_add_transaction.*


class CreateNewTransactionFragment: Fragment(),AdapterView.OnItemSelectedListener {

    var trans= ItemForListTransaction()
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
        val spin = item_income
        val adapt :ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this.context!!,R.array.choose,android.R.layout.simple_spinner_item)
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter = adapt
        spin.onItemSelectedListener = this
        add_but.setOnClickListener{
            trans.name = item_name.text.toString()
            trans.category=item_category.text.toString()
            trans.money=item_money.text.toString().toDouble()

           // trans.income_or_not=item_income.
            trans.id=9
            trans.date = "22.02"
            viewModel.postTransaction(trans)
            activity!!.supportFragmentManager.popBackStack()
            Toast.makeText(this.context,"POST SUCCSESSFUl",Toast.LENGTH_SHORT).show()

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
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val text = parent!!.getItemAtPosition(position).toString()
        trans.income_or_not = text
    }
}


