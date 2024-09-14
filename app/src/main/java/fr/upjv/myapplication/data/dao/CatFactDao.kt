package fr.upjv.myapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.upjv.myapplication.model.CatFactEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CatFactDao {

    @Query("SELECT * FROM cat_fact_table ORDER BY fact ASC")
    fun selectAll(): Flow<List<CatFactEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(catFactEntity: CatFactEntity)

    @Query("DELETE FROM cat_fact_table")
    fun deleteAll()
}
