package com.vladshvyrev.moneytracer.Repository.network

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_list")
data class ItemForSavedList(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "category") var category: String,
    @ColumnInfo(name = "money") var money: Double,
    @ColumnInfo(name = "income") var income_or_not: String,
    @ColumnInfo(name = "date") var date: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
