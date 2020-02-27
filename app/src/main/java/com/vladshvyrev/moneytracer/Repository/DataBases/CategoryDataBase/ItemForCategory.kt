package com.vladshvyrev.moneytracer.Repository.network

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_list")
data class ItemForCategory(
    var category: String?,
    var income_or_not: String?,
    @Embedded
    var accItem: ItemForAccounts?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
