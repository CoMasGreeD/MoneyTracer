package com.vladshvyrev.moneytracer.Repository.network

import androidx.lifecycle.LiveData
import androidx.room.*
import com.vladshvyrev.moneytracer.Repository.network.ItemForCategory
import java.sql.RowId

@Dao
interface CategoryDao {

        @Insert
        fun insert(note: ItemForCategory)

        @Delete
        fun deleteFromList(note : ItemForCategory)

        @Query("SELECT * FROM category_list ")
        fun getAllCategory(): List<ItemForCategory>


}