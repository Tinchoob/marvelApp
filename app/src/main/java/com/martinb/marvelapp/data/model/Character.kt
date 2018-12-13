package com.martinb.marvelapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(val code: String, val status: String, val copyright: String,
                     val attributionText: String, val attributtionHTML: String, val data: Data, val etag: String) : Parcelable


