package com.viajabessa.viajabessaapp.model

import java.io.Serializable

class PhoneInfo : Serializable {
    var model : String? = null
    var android_version : String? = null
    var manufacturer : String? = null

    constructor(model : String, manufacturer : String, android_ver : String){
        this.android_version = android_ver
        this.manufacturer = manufacturer
        this.model = model

    }
}