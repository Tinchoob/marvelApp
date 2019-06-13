package com.martinb.marvelapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Series(val avaliable : String , val returned: String, val collectionURI: String, val items: List<Item>) : Parcelable