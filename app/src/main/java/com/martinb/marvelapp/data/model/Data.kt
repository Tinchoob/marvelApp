package com.martinb.marvelapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(val offset: String, val limit: String, val total: String, val count: String, val results: List<Result>) : Parcelable
