package com.martinb.marvelapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Url {

    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null

}
