package com.vladshvyrev.moneytracer.Repository.network


import android.os.AsyncTask
import androidx.lifecycle.LiveData


class RepositoryForCategory(private val noteDao: CategoryDao) {

    private val allNotes: LiveData<List<ItemForCategory>> = noteDao.getAllCategory()

    fun insert(note: ItemForCategory) {
        InsertNoteAsyncTask(
            noteDao
        ).execute(note)
    }

    fun deleteAllNotes() {
        DeleteAllNotesAsyncTask(
            noteDao
        ).execute()
    }

    fun getAllNotes(): LiveData<List<ItemForCategory>> {
        return allNotes
    }

    private class InsertNoteAsyncTask(val noteDao: CategoryDao) : AsyncTask<ItemForCategory, Unit, Unit>() {

        override fun doInBackground(vararg note: ItemForCategory?) {
            noteDao.insert(note[0]!!)
        }
    }


    private class DeleteAllNotesAsyncTask(val noteDao: CategoryDao) : AsyncTask<Unit, Unit, Unit>() {

        override fun doInBackground(vararg p0: Unit?) {
            noteDao.deleteAllNotes()
        }
    }

}