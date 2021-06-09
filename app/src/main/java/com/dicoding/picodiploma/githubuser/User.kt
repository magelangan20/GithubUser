package com.dicoding.picodiploma.githubuser

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class User(
    var photo: Int,
    var username: String?,
    var repository: String?,
    var followers: String?,
    var following: String?,
    var name: String?,
    var company: String?,
    var location: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(photo)
        parcel.writeString(username)
        parcel.writeString(repository)
        parcel.writeString(followers)
        parcel.writeString(following)
        parcel.writeString(name)
        parcel.writeString(company)
        parcel.writeString(location)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}