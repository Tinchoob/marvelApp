package com.martinb.marvelapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("modified")
    @Expose
    var modified: String? = null
    @SerializedName("resourceURI")
    @Expose
    var resourceURI: String? = null
    @SerializedName("urls")
    @Expose
    var urls: List<Url>? = null
    @SerializedName("thumbnail")
    @Expose
    var thumbnail: Thumbnail? = null
    @SerializedName("comics")
    @Expose
    var comics: Comics? = null
    @SerializedName("stories")
    @Expose
    var stories: Stories? = null
    @SerializedName("events")
    @Expose
    var events: Events? = null
    @SerializedName("series")
    @Expose
    var series: Series? = null

}
