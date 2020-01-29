package com.viajabessa.viajabessaapp.model

import java.io.Serializable

class Destination : Serializable {
    var image_url : String? = null
    var price : String? = null
    var location : String? = null
    var desc : String? = null

    constructor( url : String, price : String, location : String) {
        image_url = url
        this.price = price
        this.location = location
    }
}

