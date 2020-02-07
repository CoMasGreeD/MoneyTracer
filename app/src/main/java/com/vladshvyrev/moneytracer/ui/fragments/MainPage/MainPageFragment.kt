package com.vladshvyrev.moneytracer.ui.fragments.MainPage

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladshvyrev.moneytracer.MainActivity
import com.vladshvyrev.moneytracer.R
import com.vladshvyrev.moneytracer.Repository.network.ItemForListTransaction
import com.vladshvyrev.moneytracer.ui.fragments.AccountsFragment.AccountsFragment
import com.vladshvyrev.moneytracer.ui.fragments.ListOfCategoryFragment.ListOfCategoryFragment
import com.vladshvyrev.moneytracer.ui.fragments.ListOfSavedTransactionFragment.ListOfSavedTransactionFragment
import kotlinx.android.synthetic.main.fragment_main_page.*
import kotlinx.android.synthetic.main.toolbar.*

class MainPageFragment : Fragment() {
    lateinit var viewModel: MainPageViewModel
    private lateinit var blogAdapter: DataAdapterForMainPage
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_page, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(my_Toolbar)
        setHasOptionsMenu(true)
        initRecyclerView()
        var data: ArrayList<ItemForListTransaction> = createDataSet()
        addDataSet(data)
        new_transaction.setOnClickListener {
            (activity as MainActivity).startFragmentForAddTransaction()
        }
    }

    private fun addDataSet(data: ArrayList<ItemForListTransaction>) {
        blogAdapter.submitList(data)
    }

    private fun createDataSet(): ArrayList<ItemForListTransaction> {
        val listData = ArrayList<ItemForListTransaction>()
        listData.add(ItemForListTransaction(1, "car", "market", "-", "01.02", 15000.toDouble()))
        listData.add(ItemForListTransaction(2, "bread", "eat", "-", "02.02", 1.toDouble()))
        listData.add(ItemForListTransaction(3, "pen", "market", "-", "03.02", 15.toDouble()))
        listData.add(ItemForListTransaction(4, "notebook", "market", "-", "11.02", 1000.toDouble()))
        listData.add(ItemForListTransaction(5, "milk", "eat", "-", "21.02", 1.5.toDouble()))
        listData.add(ItemForListTransaction(6, "water", "eat", "-", "23.02", 0.5.toDouble()))
        listData.add(ItemForListTransaction(7, "salary", "work", "+", "01.02", 2000.toDouble()))
        listData.add(ItemForListTransaction(2, "bread", "eat", "-", "02.02", 1.toDouble()))
        listData.add(ItemForListTransaction(3, "pen", "market", "-", "03.02", 15.toDouble()))
        listData.add(ItemForListTransaction(4, "notebook", "market", "-", "11.02", 1000.toDouble()))
        listData.add(ItemForListTransaction(5, "milk", "eat", "-", "21.02", 1.5.toDouble()))
        listData.add(ItemForListTransaction(6, "water", "eat", "-", "23.02", 0.5.toDouble()))
        listData.add(ItemForListTransaction(7, "salary", "work", "+", "01.02", 2000.toDouble()))
        listData.add(ItemForListTransaction(2, "bread", "eat", "-", "02.02", 1.toDouble()))
        listData.add(ItemForListTransaction(3, "pen", "market", "-", "03.02", 15.toDouble()))
        listData.add(ItemForListTransaction(4, "notebook", "market", "-", "11.02", 1000.toDouble()))
        listData.add(ItemForListTransaction(5, "milk", "eat", "-", "21.02", 1.5.toDouble()))
        listData.add(ItemForListTransaction(6, "water", "eat", "-", "23.02", 0.5.toDouble()))
        listData.add(ItemForListTransaction(7, "salary", "work", "+", "01.02", 2000.toDouble()))



        return listData
    }

    private fun initRecyclerView() {
        context?.let {
            recycler_view.apply {
                layoutManager = LinearLayoutManager(it, LinearLayoutManager.VERTICAL, false)
                blogAdapter = DataAdapterForMainPage()
                adapter = blogAdapter
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        activity!!.supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,
                when(item?.itemId){
                    R.id.item_1 -> ListOfCategoryFragment()
                    R.id.item_2 -> AccountsFragment()
                    R.id.item_3 -> ListOfSavedTransactionFragment()
                    else -> return super.onOptionsItemSelected(item)
                })
            .addToBackStack(" ")
            .commit()

        return true
    }
}