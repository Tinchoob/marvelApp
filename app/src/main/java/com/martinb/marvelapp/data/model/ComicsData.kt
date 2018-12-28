package com.martinb.marvelapp.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ComicsData(@field:Json(name="results")val comicInformation: List<ComicInformation>) : Parcelable