package com.vladshvyrev.moneytracer.ui.fragments.AccountsFragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladshvyrev.moneytracer.R
import com.vladshvyrev.moneytracer.Repository.network.ItemForAccounts
import kotlinx.android.synthetic.main.fragment_main_page.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar_only_menu.*



class AccountsFragment: Fragment() {
    private lateinit var blogAdapter: DataAdapterForAccounts
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_accounts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(my_Toolbar)
        setHasOptionsMenu(true)
        initRecyclerView()
        addDataSet(createDataSet())
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main, menu)
    }
    private fun createDataSet(): ArrayList<ItemForAccounts> {
        val listData = ArrayList<ItemForAccounts>()
        listData.add(ItemForAccounts(1, "Work", 10000.toDouble()))
        listData.add(ItemForAccounts(2, "Bank",  100000.toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(1, "Work", 10000.toDouble()))
        listData.add(ItemForAccounts(1, "Work", 10000.toDouble()))
        listData.add(ItemForAccounts(2, "Bank",  100000.toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(1, "Work", 10000.toDouble()))
        listData.add(ItemForAccounts(1, "Work", 10000.toDouble()))
        listData.add(ItemForAccounts(2, "Bank",  100000.toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(1, "Work", 10000.toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(1, "Work", 10000.toDouble()))
        listData.add(ItemForAccounts(1, "Work", 10000.toDouble()))
        listData.add(ItemForAccounts(2, "Bank",  100000.toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(1, "Work", 10000.toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(1, "Work", 10000.toDouble()))
        listData.add(ItemForAccounts(1, "Work", 10000.toDouble()))
        listData.add(ItemForAccounts(2, "Bank",  100000.toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
        listData.add(ItemForAccounts(1, "Work", 10000.toDouble()))

        return listData
    }
    private fun addDataSet(data: ArrayList<ItemForAccounts>) {
        blogAdapter.submitList(data)
    }
    private fun initRecyclerView() {
        context?.let {
            recycler_view.apply {
                layoutManager = LinearLayoutManager(it, LinearLayoutManager.VERTICAL, false)
                blogAdapter = DataAdapterForAccounts()
                adapter = blogAdapter
            }
        }
    }
}