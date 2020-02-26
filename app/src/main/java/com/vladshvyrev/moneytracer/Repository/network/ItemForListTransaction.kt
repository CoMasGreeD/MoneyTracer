package com.vladshvyrev.moneytracer.Repository.network

data class ItemForListTransaction (
    var id : Int?=null,
    var name : String?=null,
    var category :String?=null,
    var money : Double?=null,
    var income_or_not:String?=null,
    var date: String?=null
)