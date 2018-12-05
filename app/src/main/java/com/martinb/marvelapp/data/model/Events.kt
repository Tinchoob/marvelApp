package com.martinb.marvelapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Events {

    @SerializedName("available")
    @Expose
    var available: String? = null
    @SerializedName("returned")
    @Expose
    var returned: String? = null
    @SerializedName("collectionURI")
    @Expose
    var collectionURI: String? = null
    @SerializedName("items")
    @Expose
    var items: List<Item>? = null

}
