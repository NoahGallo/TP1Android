package fr.upjv.myapplication.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.upjv.myapplication.data.dao.AndroidVersionDao
import fr.upjv.myapplication.data.dao.ChuckNorrisDao
import fr.upjv.myapplication.data.model.AndroidVersionEntity
import fr.upjv.myapplication.model.ChuckNorrisEntity


@Database(
    entities = [
        AndroidVersionEntity::class,
        ChuckNorrisEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun androidVersionDao(): AndroidVersionDao
    abstract fun chuckNorrisDao(): ChuckNorrisDao
}


