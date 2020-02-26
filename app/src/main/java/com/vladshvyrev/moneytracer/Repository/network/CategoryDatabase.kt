package com.vladshvyrev.moneytracer.Repository.network

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [ItemForCategory::class], version = 1)
abstract class CategoryDatabase : RoomDatabase() {

    abstract fun noteDao(): CategoryDao


    companion object {
        private var instance: CategoryDatabase? = null
        fun getInstance(context: Context): CategoryDatabase? {
            if (instance == null) {
                synchronized(CategoryDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CategoryDatabase::class.java, "notes_database"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build()
                }
            }
            return instance!!
        }

        fun destroyInstance() {
            instance = null
        }

        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsyncTask(instance)
                    .execute()
            }
        }
    }

class PopulateDbAsyncTask(db: CategoryDatabase?) : AsyncTask<Unit, Unit, Unit>() {
    private val noteDao = db?.noteDao()

    override fun doInBackground(vararg p0: Unit?) {
        noteDao?.insert(ItemForCategory( "description 1","income"))
        noteDao?.insert(ItemForCategory( "description 2","spending"))
        noteDao?.insert(ItemForCategory( "description 3","income"))
    }
}
}
