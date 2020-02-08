package com.vladshvyrev.moneytracer.ui.fragments.ListOfCategoryFragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladshvyrev.moneytracer.R
import com.vladshvyrev.moneytracer.Repository.network.ItemForAccounts
import com.vladshvyrev.moneytracer.Repository.network.ItemForCategory
import com.vladshvyrev.moneytracer.Repository.network.ItemForListTransaction
import com.vladshvyrev.moneytracer.ui.fragments.AccountsFragment.AccountsFragment
import com.vladshvyrev.moneytracer.ui.fragments.AccountsFragment.DataAdapterForAccounts
import com.vladshvyrev.moneytracer.ui.fragments.CreateNewCategory.CreateNewCategoryFragment
import com.vladshvyrev.moneytracer.ui.fragments.ListOfSavedTransactionFragment.ListOfSavedTransactionFragment
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_main_page.*
import kotlinx.android.synthetic.main.fragment_main_page.recycler_view


class ListOfCategoryFragment : Fragment() {
    private lateinit var blogAdapter: DataAdapterForCategory
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        initRecyclerView()
        addDataSet(createDataSet())
        add_category.setOnClickListener{
            var dialog = CreateNewCategoryFragment()
            dialog.show(activity!!.supportFragmentManager,"custom")
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main, menu)
    }
    private fun addDataSet(data: ArrayList<ItemForCategory>) {
        blogAdapter.submitList(data)
    }

    private fun createDataSet(): ArrayList<ItemForCategory> {
        val listData = ArrayList<ItemForCategory>()
        listData.add(ItemForCategory(1, "market"))
        listData.add(ItemForCategory(2, "eat"))
        listData.add(ItemForCategory(7, "work"))
        return listData
    }

    private fun initRecyclerView() {
        context?.let {
            recycler_view.apply {
                layoutManager = LinearLayoutManager(it, LinearLayoutManager.VERTICAL, false)
                blogAdapter = DataAdapterForCategory()
                adapter = blogAdapter
            }
        }
    }

}