package fr.upjv.myapplication.model

import fr.upjv.myapplication.data.model.MyCarObject

// Sealed interface for different types of items
sealed interface ItemUi {
    data class Item(
        val brandName: String,
        val modelName: String,
        val power: String, // Car power
    ) : ItemUi

    data class Header(
        val title: String,
    ) : ItemUi
}

// Extension function to convert List<MyCarObject> to List<ItemUi.MyCarObject>
fun List<MyCarObject>.toUi(): List<ItemUi.Item>{
    return map { currentCarObject ->
        ItemUi.Item(
            brandName = currentCarObject.brandName,
            modelName = currentCarObject.modelName,
            power = currentCarObject.power
        )
    }
}
