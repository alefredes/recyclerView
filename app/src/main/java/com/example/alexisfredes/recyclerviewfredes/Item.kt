package com.example.alexisfredes.recyclerviewfredes

import android.os.Parcel
import android.os.Parcelable

fun getItems():List<Item> {
    return (1..8).map { Item(it.toLong(),"Title $it","https://picsum.photos/400/400/?image=$it") }
}

data class Item(val id: Long, val title: String, val url: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(title)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}