package com.example.myanime

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
val name: String,
    val desc: String,
    val photo: Int,
    val eps: String
) : Parcelable

