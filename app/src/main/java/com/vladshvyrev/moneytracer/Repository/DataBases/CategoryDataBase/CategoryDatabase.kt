package com.vladshvyrev.moneytracer.Repository.network


import androidx.room.Database

import androidx.room.RoomDatabase



@Database(entities = arrayOf(ItemForCategory::class), version = 4)
abstract class CategoryDatabase : RoomDatabase() {
    abstract fun getCategoryDataBase(): CategoryDao

   // abstract fun insertNewCategory(): CategoryDao
//    abstract fun noteDao(): CategoryDao
//
//
//    companion object {
//        private var instance: CategoryDatabase? = null
//        fun getInstance(context: Context): CategoryDatabase? {
//            if (instance == null) {
//                synchronized(CategoryDatabase::class) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        CategoryDatabase::class.java, "notes_database"
//                    )
//                        .fallbackToDestructiveMigration()
//                        .addCallback(roomCallback)
//                        .build()
//                }
//            }
//            return instance!!
//        }
//
//        fun destroyInstance() {
//            instance = null
//        }
//
//        private val roomCallback = object : RoomDatabase.Callback() {
//            override fun onCreate(db: SupportSQLiteDatabase) {
//                super.onCreate(db)
//                PopulateDbAsyncTask(instance)
//                    .execute()
//            }
//        }
//    }
//
//class PopulateDbAsyncTask(db: CategoryDatabase?) : AsyncTask<Unit, Unit, Unit>() {
//    private val noteDao = db?.noteDao()
//
//    override fun doInBackground(vararg p0: Unit?) {
//        noteDao?.insert(ItemForCategory( "description 1","income"))
//        noteDao?.insert(ItemForCategory( "description 2","spending"))
//        noteDao?.insert(ItemForCategory( "description 3","income"))
//    }
//}
}
