package fr.upjv.myapplication.data.model

import fr.upjv.myapplication.model.ChuckNorrisEntity

data class ChuckNorrisObject(
    val quote: String,
    val iconUrl: String,
)


fun List<ChuckNorrisEntity>.toUi(): List<ChuckNorrisObject> {
    return map { eachEntity ->
        ChuckNorrisObject(
            quote = eachEntity.quote,
            iconUrl = eachEntity.iconUrl,
        )
    }
}
