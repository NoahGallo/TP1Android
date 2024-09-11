package fr.upjv.myapplication.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.upjv.myapplication.data.dao.AndroidVersionDao
import fr.upjv.myapplication.data.model.AndroidVersionEntity


@Database(
    entities = [
        AndroidVersionEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun androidVersionDao(): AndroidVersionDao
}

