package com.vladshvyrev.moneytracer.ui.fragments.ListOfCategoryFragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladshvyrev.moneytracer.R
import com.vladshvyrev.moneytracer.Repository.network.ItemForAccounts
import com.vladshvyrev.moneytracer.Repository.network.ItemForCategory
import com.vladshvyrev.moneytracer.Repository.network.ItemForListTransaction
import com.vladshvyrev.moneytracer.ui.activities.AddCategoryActivity
import com.vladshvyrev.moneytracer.ui.fragments.AccountsFragment.AccountsFragment
import com.vladshvyrev.moneytracer.ui.fragments.AccountsFragment.DataAdapterForAccounts
import com.vladshvyrev.moneytracer.ui.fragments.CreateNewCategory.CreateNewCategoryFragment
import com.vladshvyrev.moneytracer.ui.fragments.ListOfSavedTransactionFragment.ListOfSavedTransactionFragment
import com.vladshvyrev.moneytracer.ui.fragments.MainPage.MainPageViewModel
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_main_page.*
import kotlinx.android.synthetic.main.fragment_main_page.recycler_view
import org.koin.android.ext.android.inject


class ListOfCategoryFragment : Fragment() {
    private val viewModel: ListOfCategoryViewModel by inject()
    private  lateinit var blogAdapter: DataAdapterForCategory
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // viewModel = ViewModelProviders.of(this).get(ListOfCategoryViewModel::class.java)
        viewModel.getAllCategory().observe(this, observer)

        setHasOptionsMenu(true)
        initRecyclerView()

        add_category.setOnClickListener {
            startActivityForResult(
                Intent(this.context, AddCategoryActivity::class.java),
                ADD_NOTE_REQUEST
            )
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_NOTE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val newCategory = ItemForCategory(
                data.getStringExtra(AddCategoryActivity.EXTRA_TITLE),
                data.getStringExtra(AddCategoryActivity.EXTRA_DESCRIPTION)
            )
           viewModel.insert(newCategory)

            Toast.makeText(this.context, "Note saved!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this.context, "Note not saved!", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main, menu)
    }

    private fun addDataSet(data: List<ItemForCategory>) {
        blogAdapter.submitList(data)
    }

//    private fun createDataSet(): ArrayList<ItemForCategory> {
//        val listData = ArrayList<ItemForCategory>()
//        listData.add(ItemForCategory(1, "market","spending"))
//        listData.add(ItemForCategory(2, "eat","income"))
//        listData.add(ItemForCategory(7, "work","income"))
//        return listData
//    }

    private fun initRecyclerView() {
        context?.let {
            recycler_view.apply {
                layoutManager = LinearLayoutManager(it, LinearLayoutManager.VERTICAL, false)
                blogAdapter = DataAdapterForCategory()
                adapter = blogAdapter
            }
        }
    }

    private val observer = Observer<List<ItemForCategory>> { list ->
        list?.let {
            blogAdapter.submitList(it)
        }
    }
    companion object{
        private const val ADD_NOTE_REQUEST = 1
    }
}