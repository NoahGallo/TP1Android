import fr.upjv.myapplication.data.model.ChuckNorrisObject

data class ChuckItemUi(
    val quote: String,
    val iconUrl: String,
)


fun List<ChuckNorrisObject>.toUi() : List<ChuckItemUi> {
    return map { item ->
        ChuckItemUi(
            quote = item.quote,
            iconUrl = item.iconUrl,
        )
    }
}