package com.vladshvyrev.moneytracer.ui.fragments.MainPage

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladshvyrev.moneytracer.MainActivity
import com.vladshvyrev.moneytracer.R
import com.vladshvyrev.moneytracer.Repository.network.ItemForListTransaction
import com.vladshvyrev.moneytracer.Repository.network.TransactionsList
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
        setHasOptionsMenu(true)
        viewModel = ViewModelProviders.of(this).get(MainPageViewModel::class.java)
        viewModel.userListLiveData.observe(this,observer)
        viewModel.getTransactionList()
        context?.let {
            recycler_view.apply {
                layoutManager = LinearLayoutManager(it, LinearLayoutManager.VERTICAL, false)
                blogAdapter = DataAdapterForMainPage()
                adapter = blogAdapter
            }
        }
        new_transaction.setOnClickListener {
            (activity as MainActivity).startFragmentForAddTransaction()
        }
    }

    private fun addDataSet(data: List<ItemForListTransaction>) {
        blogAdapter.submitList(data)
    }
private val observer = Observer<TransactionsList> { response ->
    response.result?.let { result ->
        addDataSet(result)
    }
}
    private fun initRecyclerView() {

    }

}