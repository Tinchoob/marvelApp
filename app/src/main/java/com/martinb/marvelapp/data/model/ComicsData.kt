package com.martinb.marvelapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ComicsData(@SerializedName("results")val comicInformation: List<ComicInformation>) : Parcelable