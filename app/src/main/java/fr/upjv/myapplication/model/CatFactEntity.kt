package fr.upjv.myapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cat_fact_table")
data class CatFactEntity(
    @ColumnInfo(name = "fact")
    val fact: String,

    @ColumnInfo(name = "length")
    val length: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
