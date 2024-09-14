package fr.upjv.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CatFactDto(
    @Expose
    @SerializedName("fact")
    val fact: String,

    @Expose
    @SerializedName("length")
    val length: Int
)

fun CatFactDto.toRoom(): CatFactEntity {
    return CatFactEntity(
        fact = fact,
        length = length
    )
}
