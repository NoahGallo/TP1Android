package fr.upjv.myapplication.data.Repository

import fr.upjv.myapplication.architecture.CustomApplication
import fr.upjv.myapplication.architecture.RetrofitBuilder
import fr.upjv.myapplication.data.model.CatFactObject
import fr.upjv.myapplication.data.model.toUi
import fr.upjv.myapplication.model.toRoom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CatFactRepository {

    private val catFactDao = CustomApplication.instance.mApplicationDatabase.catFactDao()

    suspend fun fetchData() {
        catFactDao.insert(RetrofitBuilder.getCatFact().getRandomCatFact().toRoom())
    }

    fun deleteAll() {
        catFactDao.deleteAll()
    }

    fun selectAll(): Flow<List<CatFactObject>> {
        return catFactDao.selectAll().map { list ->
            list.toUi()
        }
    }
}
