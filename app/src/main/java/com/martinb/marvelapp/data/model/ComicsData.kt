package com.martinb.marvelapp.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ComicsData(@Json(name="results")val results: List<ComicInformation>) : Parcelable