package com.jrektor.mobile.admin

class ItemKeuangan {

    var id: Int
    var price: Int
    var description: String
    var date_in: String

    constructor(id: Int, price: Int, description: String, date_in: String) {
        this.id = id
        this.price = price
        this.description = description
        this.date_in = date_in
    }
}