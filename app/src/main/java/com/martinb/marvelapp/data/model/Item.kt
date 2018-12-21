package com.martinb.marvelapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(val resourceURI: String, val name: String, val type: String) : Parcelable
