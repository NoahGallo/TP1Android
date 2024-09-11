package fr.upjv.myapplication.data

import fr.upjv.myapplication.architecture.CustomApplication
import fr.upjv.myapplication.data.model.MyCarObject
import fr.upjv.myapplication.data.model.toRoomObject
import fr.upjv.myapplication.data.model.toUi
import fr.upjv.myapplication.model.ItemUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class AndroidVersionRepository {

    // Function to return the car list as a Flow without grouping
    fun getCarList(): Flow<List<MyCarObject>> {
        return flow {
            emit(
                listOf(
                    MyCarObject(brandName = "Audi", modelName = "RS3", power = "400 HP"),
                    MyCarObject(brandName = "Audi", modelName = "RS6", power = "591 HP"),
                    MyCarObject(brandName = "BMW", modelName = "M4", power = "503 HP"),
                    MyCarObject(brandName = "BMW", modelName = "M3", power = "473 HP"),
                    MyCarObject(brandName = "Mercedes", modelName = "C63 AMG", power = "503 HP"),
                    MyCarObject(brandName = "Mercedes", modelName = "E63 AMG", power = "603 HP"),
                    MyCarObject(brandName = "Porsche", modelName = "911 Turbo S", power = "640 HP"),
                    MyCarObject(brandName = "Porsche", modelName = "718 Cayman GT4", power = "414 HP"),
                    MyCarObject(brandName = "Nissan", modelName = "GT-R", power = "565 HP"),
                    MyCarObject(brandName = "Ford", modelName = "Mustang Shelby GT500", power = "760 HP"),
                    MyCarObject(brandName = "Chevrolet", modelName = "Camaro ZL1", power = "650 HP"),
                    MyCarObject(brandName = "Lamborghini", modelName = "Huracán", power = "631 HP"),
                    MyCarObject(brandName = "Ferrari", modelName = "488 Pista", power = "710 HP"),
                    MyCarObject(brandName = "McLaren", modelName = "720S", power = "710 HP"),
                    MyCarObject(brandName = "Aston Martin", modelName = "Vantage", power = "503 HP"),
                    MyCarObject(brandName = "Dodge", modelName = "Charger SRT Hellcat", power = "707 HP"),
                    MyCarObject(brandName = "Hyundai", modelName = "i30 N", power = "276 HP"),
                    MyCarObject(brandName = "Hyundai", modelName = "Kona N", power = "276 HP"),
                    MyCarObject(brandName = "Hyundai", modelName = "i20 N", power = "204 HP")
                )
            )
        }
    }

    private val androidVersionDao =
        CustomApplication.instance.mApplicationDatabase.androidVersionDao()


    fun selectAllAndroidVersion(): Flow<List<ItemUi.Item>> {
        return androidVersionDao.selectAll().map {
            it.toUi()
        }
    }


    fun insertAndroidVersion(androidObject: ItemUi.Item) {
        androidVersionDao.insert(androidObject.toRoomObject())
    }


    fun deleteAllAndroidVersion() {
        androidVersionDao.deleteAll()
    }

}

