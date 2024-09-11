package fr.upjv.myapplication.data.Repository

import fr.upjv.myapplication.architecture.CustomApplication
import fr.upjv.myapplication.architecture.RetrofitBuilder
import fr.upjv.myapplication.data.model.ChuckNorrisObject
import fr.upjv.myapplication.data.model.toUi
import fr.upjv.myapplication.model.toRoom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChuckNorrisQuoteRepository {


    private val chuckNorrisDao = CustomApplication.instance.mApplicationDatabase.chuckNorrisDao()


    suspend fun fetchData() {
        chuckNorrisDao.insert(RetrofitBuilder.getChuckNorrisQuote().getRandomQuote().toRoom())
    }


    fun deleteAll() {
        chuckNorrisDao.deleteAll()
    }


    fun selectAll(): Flow<List<ChuckNorrisObject>> {
        return chuckNorrisDao.selectAll().map { list ->
            list.toUi()
        }
    }
}
