package com.example.treinamento.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Livro (@SerializedName("title") val titulo: String?,
                  @SerializedName("price") val preco: Double,
                  @SerializedName("writer") val autor: String?,
                  @SerializedName("thumbnailHd") val capa: String?,
                  @SerializedName("date") val dataLancamento: String?): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titulo)
        parcel.writeDouble(preco)
        parcel.writeString(autor)
        parcel.writeString(capa)
        parcel.writeString(dataLancamento)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Livro> {
        override fun createFromParcel(parcel: Parcel): Livro {
            return Livro(parcel)
        }

        override fun newArray(size: Int): Array<Livro?> {
            return arrayOfNulls(size)
        }
    }
}
