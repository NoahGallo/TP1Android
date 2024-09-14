import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.upjv.myapplication.data.Repository.CatFactRepository
import fr.upjv.myapplication.data.model.CatFactObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CatFactViewModel : ViewModel() {
    private val catFactRepository: CatFactRepository by lazy { CatFactRepository() }

    private val _catFacts: Flow<List<CatFactObject>>
        get() = catFactRepository.selectAll()

    val catFacts = _catFacts

    fun insertNewCatFact() {
        viewModelScope.launch(Dispatchers.IO) {
            catFactRepository.fetchData()
        }
    }

    fun deleteAllCatFacts() {
        viewModelScope.launch(Dispatchers.IO) {
            catFactRepository.deleteAll()
        }
    }
}
