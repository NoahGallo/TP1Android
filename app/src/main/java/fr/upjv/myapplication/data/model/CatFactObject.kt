package fr.upjv.myapplication.data.model

import fr.upjv.myapplication.model.CatFactEntity

data class CatFactObject(
    val fact: String,
    val length: Int,
)

fun List<CatFactEntity>.toUi(): List<CatFactObject> {
    return map { eachEntity ->
        CatFactObject(
            fact = eachEntity.fact,
            length = eachEntity.length
        )
    }
}
