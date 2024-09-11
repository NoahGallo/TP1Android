import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.upjv.myapplication.data.AndroidVersionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import fr.upjv.myapplication.model.ItemUi
import fr.upjv.myapplication.model.toUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class AndroidVersionViewModel : ViewModel() {

    private val androidVersionRepository: AndroidVersionRepository by lazy { AndroidVersionRepository() }

    // Using Flow to fetch and map the car list from the repository
    private val _androidVersionList: Flow<List<ItemUi>>
        get() = androidVersionRepository.selectAllAndroidVersion().map { carList ->
            carList.groupBy { carObject ->
                carObject.brandName
            }.flatMap { groupedCars ->
                buildList {
                    // Add a header for each brand name
                    add(ItemUi.Header(title = groupedCars.key))
                    // Add all cars under that brand, converting them to UI items
                    addAll(groupedCars.value)
                }
            }
        }

    // Public getter for the Flow
    val androidVersionList: Flow<List<ItemUi>> get() = _androidVersionList

    // The init block is removed, as data fetching is handled by the Flow.

    fun insertAndroidVersion() {
        viewModelScope.launch(Dispatchers.IO) {
            val random = Random.nextInt(0, 10)
            androidVersionRepository.insertAndroidVersion(
                ItemUi.Item("Android $random", "$random",
                    "$random")
            )
        }
    }


    fun deleteAllAndroidVersion() {
        viewModelScope.launch(Dispatchers.IO) {
            androidVersionRepository.deleteAllAndroidVersion()
        }
    }
}



