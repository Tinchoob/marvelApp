package com.martinb.marvelapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ComicInformation(val id: Int,val digitalId: Int,val title: String,
                            val issueNumber: Int,val variantDescription: String,
                            val description: String, val modified: String,
                            val isbn: String,val upc: String,val diamondCode: String,
                            val ean :String, val issn: String,val format: String,
                            val pageCount: Int,val resurceURI: String,val urls: List<Url>,
                            val series: Series,val dates: List<Date>, val prices: List<Price>,
                            val thumbnail: Thumbnail,val images: List<Image>) : Parcelable
//public class Result {
//
//
//    private List<Object> variants = null;
//    @SerializedName("collections")
//    @Expose
//    private List<Object> collections = null;
//    @SerializedName("collectedIssues")
//    @Expose
//    private List<Object> collectedIssues = null;
//    @SerializedName("dates")
//    @Expose
//    private List<Date> dates = null;
//    @SerializedName("prices")
//    @Expose
//    private List<Price> prices = null;
//    @SerializedName("thumbnail")
//    @Expose
//    private Thumbnail thumbnail;
//    @SerializedName("images")
//    @Expose
//    private List<Image> images = null;
//    @SerializedName("creators")
//    @Expose
//    private Creators creators;
//    @SerializedName("characters")
//    @Expose
//    private Characters characters;
//    @SerializedName("stories")
//    @Expose
//    private Stories stories;
//    @SerializedName("events")
//    @Expose