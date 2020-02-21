package com.vladshvyrev.moneytracer.ui.fragments.ListOfSavedTransactionFragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladshvyrev.moneytracer.R
import com.vladshvyrev.moneytracer.Repository.network.ItemForListTransaction
import com.vladshvyrev.moneytracer.ui.fragments.AccountsFragment.AccountsFragment
import com.vladshvyrev.moneytracer.ui.fragments.ListOfCategoryFragment.ListOfCategoryFragment
import com.vladshvyrev.moneytracer.ui.fragments.MainPage.DataAdapterForMainPage
import kotlinx.android.synthetic.main.fragment_main_page.*

class ListOfSavedTransactionFragment: Fragment() {
    private lateinit var blogAdapter: DataAdapterForSavedTransaction
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_saved_list, container, false)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main, menu)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        initRecyclerView()
        addDataSet(createDataSet())

    }
    private fun addDataSet(data: ArrayList<ItemForListTransaction>) {
        blogAdapter.submitList(data)
    }

    private fun createDataSet(): ArrayList<ItemForListTransaction> {
        val listData = ArrayList<ItemForListTransaction>()
        listData.add(ItemForListTransaction(1, "car", "market", 15000.toDouble(),"-", "01.02" ))
        listData.add(ItemForListTransaction(2, "bread", "eat", 1.toDouble(),"-", "02.02" ))
        listData.add(ItemForListTransaction(3, "pen", "market", 15.toDouble(),"-", "03.02"))

        return listData
    }

    private fun initRecyclerView() {
        context?.let {
            recycler_view.apply {
                layoutManager = LinearLayoutManager(it, LinearLayoutManager.VERTICAL, false)
                blogAdapter = DataAdapterForSavedTransaction()
                adapter = blogAdapter
            }
        }
    }

}