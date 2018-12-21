package com.martinb.marvelapp.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ComicsResults(val code: String, val status: String, val copyright: String,
                         val attributionText: String, val attributtionHTML: String, @SerializedName("data") val comicsData: ComicsData, val etag: String) : Parcelable