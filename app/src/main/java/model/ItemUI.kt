package model

sealed interface ItemUi {
    data class MyCarObject(
        val brandName: String,
        val modelName: String,
        val power: String, // Added car power
    ) : ItemUi

    data class Header(
        val title: String,
    ) : ItemUi
}
