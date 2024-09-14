package fr.upjv.myapplication.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.upjv.myapplication.data.dao.AndroidVersionDao
import fr.upjv.myapplication.data.dao.ChuckNorrisDao
import fr.upjv.myapplication.data.dao.CatFactDao
import fr.upjv.myapplication.data.model.AndroidVersionEntity
import fr.upjv.myapplication.model.ChuckNorrisEntity
import fr.upjv.myapplication.model.CatFactEntity

@Database(
    entities = [
        AndroidVersionEntity::class,
        ChuckNorrisEntity::class,
        CatFactEntity::class
    ],
    version = 3,  // Incremented the version since you're adding a new table
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun androidVersionDao(): AndroidVersionDao
    abstract fun chuckNorrisDao(): ChuckNorrisDao
    abstract fun catFactDao(): CatFactDao  // Added the new DAO
}
