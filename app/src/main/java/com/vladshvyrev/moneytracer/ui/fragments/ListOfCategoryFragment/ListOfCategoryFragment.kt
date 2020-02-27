package com.vladshvyrev.moneytracer.ui.fragments.ListOfCategoryFragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.vladshvyrev.moneytracer.R
import com.vladshvyrev.moneytracer.Repository.network.CategoryDatabase
import com.vladshvyrev.moneytracer.Repository.network.ItemForCategory
import com.vladshvyrev.moneytracer.ui.activities.AddCategoryActivity
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_main_page.recycler_view


class ListOfCategoryFragment : Fragment() {
   // private val viewModel: ListOfCategoryViewModel by inject()
    private lateinit var db : CategoryDatabase
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
      //  viewModel.getAllCategory().observe(this, observer)
         db = Room.databaseBuilder(
            context?.applicationContext!!,
            CategoryDatabase::class.java,
            "name"
        )
           // .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
       // setHasOptionsMenu(true)
        initRecyclerView()
        val list = db.getCategoryDataBase().getAllCategory()
        addDataSet(list)
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
                data.getStringExtra(AddCategoryActivity.EXTRA_DESCRIPTION),
                null
            )

            db.getCategoryDataBase().insert(newCategory)

            Toast.makeText(this.context, "Category saved!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this.context, "Note not saved!", Toast.LENGTH_SHORT).show()
        }
    }
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.main, menu)
//    }

    private fun addDataSet(data: List<ItemForCategory>)
    {
        blogAdapter.submitList(data)
    }


    private fun initRecyclerView() {
        context?.let {
            recycler_view.apply {
                layoutManager = LinearLayoutManager(it, LinearLayoutManager.VERTICAL, false)
                blogAdapter = DataAdapterForCategory({itemView: ItemForCategory -> itemViewClicked(itemView)})
                adapter = blogAdapter
            }
        }
    }

    private val observer = Observer<List<ItemForCategory>> { list ->
        list?.let {
            blogAdapter.submitList(it)
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
        private const val ADD_NOTE_REQUEST = 1
    }
}