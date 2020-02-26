package com.vladshvyrev.moneytracer.Repository.network

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_list")
data class ItemForCategory (
    @ColumnInfo(name="category") var category : String,
    @ColumnInfo(name="income") var income_or_not :String
)
{

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}