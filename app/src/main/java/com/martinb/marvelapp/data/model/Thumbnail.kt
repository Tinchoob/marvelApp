package com.martinb.marvelapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Thumbnail(val path: String, val extension: String) : Parcelable
