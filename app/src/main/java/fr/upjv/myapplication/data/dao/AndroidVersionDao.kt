package fr.upjv.myapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.upjv.myapplication.data.model.AndroidVersionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AndroidVersionDao {

    @Query("SELECT * FROM cars ORDER BY brandName ASC")
    fun selectAll(): Flow<List<AndroidVersionEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(androidVersion: AndroidVersionEntity)


    @Query("DELETE FROM cars")
    fun deleteAll()
}
