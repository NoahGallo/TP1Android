package fr.upjv.myapplication.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import fr.upjv.myapplication.model.ItemUi

@Entity(tableName = "cars")
data class AndroidVersionEntity(

    @ColumnInfo(name = "brandName")
    val brandName: String,


    @ColumnInfo(name = "modelName")
    val modelName: String,

    @ColumnInfo(name = "power")
    val power: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

fun ItemUi.Item.toRoomObject(): AndroidVersionEntity {
    return AndroidVersionEntity(
        brandName = brandName,
        modelName = modelName,
        power = power
    )
}


fun List<AndroidVersionEntity>.toUi(): List<ItemUi.Item> {
    return map { eachItem ->
        ItemUi.Item(
            brandName = eachItem.brandName,
            modelName = eachItem.modelName,
            power = eachItem.power
        )
    }
}
