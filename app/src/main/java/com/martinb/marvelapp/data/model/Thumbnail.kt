package com.martinb.marvelapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Thumbnail {

    @SerializedName("path")
    @Expose
    var path: String? = null
    @SerializedName("extension")
    @Expose
    var extension: String? = null

}