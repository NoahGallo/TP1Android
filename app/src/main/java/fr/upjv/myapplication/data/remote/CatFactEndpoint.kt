import fr.upjv.myapplication.model.CatFactDto
import retrofit2.http.GET

interface CatFactEndpoint {

    @GET("fact")
    suspend fun getRandomCatFact(): CatFactDto
}
