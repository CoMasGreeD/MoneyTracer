package com.vladshvyrev.moneytracer.ui.fragments.AccountsFragment

import android.app.Activity
import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.vladshvyrev.moneytracer.R

import com.vladshvyrev.moneytracer.Repository.network.CategoryDatabase
import com.vladshvyrev.moneytracer.Repository.network.ItemForAccounts
import com.vladshvyrev.moneytracer.Repository.network.ItemForCategory
import com.vladshvyrev.moneytracer.ui.activities.AddAccountsActivity
import com.vladshvyrev.moneytracer.ui.activities.AddCategoryActivity
import com.vladshvyrev.moneytracer.ui.fragments.ListOfCategoryFragment.ListOfCategoryFragment
import com.vladshvyrev.moneytracer.ui.fragments.ListOfSavedTransactionFragment.ListOfSavedTransactionFragment
import kotlinx.android.synthetic.main.fragment_accounts.*
import kotlinx.android.synthetic.main.fragment_main_page.*
import kotlinx.android.synthetic.main.fragment_main_page.recycler_view


class AccountsFragment: Fragment() {
    private lateinit var db : CategoryDatabase
    private lateinit var blogAdapter: DataAdapterForAccounts
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_accounts, container, false)
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.main, menu)
//    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    db = Room.databaseBuilder(
        context?.applicationContext!!,
        CategoryDatabase::class.java,
        "name"
    )

        .allowMainThreadQueries()
        .build()
    setHasOptionsMenu(true)
    initRecyclerView()
    val list = db.getCategoryDataBase().getAllCategory()
    addDataSet(list)

    add_button.setOnClickListener {
        startActivityForResult(
            Intent(this.context, AddAccountsActivity::class.java),
            ADD_NOTE_REQUEST_2
        )
    }
            //  addDataSet(createDataSet())
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_NOTE_REQUEST_2 && resultCode == Activity.RESULT_OK && data != null) {
            val newAccounts = ItemForAccounts(
                data.getStringExtra(AddAccountsActivity.EXTRA_TITLE),
                data.getStringExtra(AddAccountsActivity.EXTRA_DESCRIPTION).toDouble()
            )
            val newCategory =ItemForCategory(null,null,newAccounts)

            db.getCategoryDataBase().insert(newCategory)

            Toast.makeText(this.context, "Category saved!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this.context, "Note not saved!", Toast.LENGTH_SHORT).show()
        }
    }
//    private fun createDataSet(): ArrayList<ItemForAccounts> {
//        val listData = ArrayList<ItemForAccounts>()
//        listData.add(ItemForAccounts(1, "Work", 10000.toDouble()))
//        listData.add(ItemForAccounts(2, "Bank",  100000.toDouble()))
//        li
//
//        listData.add(ItemForAccounts(3, "debt", (-1000).toDouble()))
//        listData.add(ItemForAccounts(1, "Work", 10000.toDouble()))
//        return listData
//    }
    private fun addDataSet(data: List<ItemForCategory>) {
        blogAdapter.submitList(data)
    }
    private fun initRecyclerView() {
        context?.let {
            recycler_view.apply {
                layoutManager = LinearLayoutManager(it, LinearLayoutManager.VERTICAL, false)
                blogAdapter = DataAdapterForAccounts({itemView: ItemForCategory -> itemViewClicked(itemView)})
                adapter = blogAdapter
            }
        }
    }
    private fun itemViewClicked(itemView: ItemForCategory) {
        val builder = AlertDialog.Builder(this.context!!)
        builder.setTitle("Androidly Alert")
        builder.setMessage("We have a message")
        //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        builder.setPositiveButton("Delete") { dialog, which ->
            db.getCategoryDataBase().deleteFromList(itemView)
        }

        builder.setNegativeButton("Cancel") { dialog, which ->
            Toast.makeText(this.context!!,
                android.R.string.no, Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }
    companion object{
        private const val ADD_NOTE_REQUEST_2 = 2
    }
}

