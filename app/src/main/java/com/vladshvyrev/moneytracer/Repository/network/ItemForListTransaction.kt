package com.vladshvyrev.moneytracer.Repository.network

data class ItemForListTransaction (
    val id : Int?=null,
    var name : String?=null,
    var category :String?=null,
    var money : Double?=null,
    var income:String?=null,
    var date: String?=null
)