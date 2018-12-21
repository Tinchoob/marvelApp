package com.martinb.marvelapp.data.model


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ComicsResults(val code: String, val status: String, val copyright: String,
                         val attributionText: String, val attributtionHTML: String, @Json(name="data") val data: ComicsData, val etag: String) : Parcelable