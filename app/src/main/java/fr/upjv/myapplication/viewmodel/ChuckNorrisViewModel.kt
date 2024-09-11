import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.upjv.myapplication.data.Repository.ChuckNorrisQuoteRepository
import fr.upjv.myapplication.data.model.ChuckNorrisObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ChuckNorrisViewModel : ViewModel() {
    private val chuckNorrisQuoteRepository: ChuckNorrisQuoteRepository by lazy { ChuckNorrisQuoteRepository() }
    private val _quotes: Flow<List<ChuckNorrisObject>>
        get() = chuckNorrisQuoteRepository.selectAll()
    val quote = _quotes
    fun insertNewQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            chuckNorrisQuoteRepository.fetchData()
        }
    }
    fun deleteAllQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            chuckNorrisQuoteRepository.deleteAll()
        }
    }
}
