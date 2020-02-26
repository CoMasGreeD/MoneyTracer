package com.vladshvyrev.moneytracer.ui.fragments.ListOfCategoryFragment

import android.app.Application
import android.content.ClipData
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.vladshvyrev.moneytracer.Repository.network.CategoryDao
import com.vladshvyrev.moneytracer.Repository.network.RepositoryForCategory
import com.vladshvyrev.moneytracer.Repository.network.ItemForCategory


    class ListOfCategoryViewModel( private var repository: RepositoryForCategory) : ViewModel() {


        private var allNotes: LiveData<List<ItemForCategory>> = repository.getAllNotes()

        fun insert(note: ItemForCategory) {
            repository.insert(note)
        }

        fun deleteAllNotes() {
            repository.deleteAllNotes()
        }

        fun getAllCategory(): LiveData<List<ItemForCategory>> {
            return allNotes
        }
    }
