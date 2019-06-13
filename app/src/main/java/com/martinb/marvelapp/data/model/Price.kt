package com.martinb.marvelapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Price(val type: String,val price: Double) : Parcelable