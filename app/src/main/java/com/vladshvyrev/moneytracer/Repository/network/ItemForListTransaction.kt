package com.vladshvyrev.moneytracer.Repository.network

data class ItemForListTransaction (
    val id : Int,
    var name : String,
    var category :String,
    var income:String,
    var date: String,
    var money : Double

)