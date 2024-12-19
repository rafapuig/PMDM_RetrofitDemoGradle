import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import response.SearchResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.converter.moshi.MoshiConverterFactory

import retrofit2.http.GET
import retrofit2.http.Query

const val APIKEY = "9985f1ee"


interface OmdbService {
    @GET("/")

    fun getMovie(@Query("t") title: String, @Query("apikey") apikey: String = APIKEY): Call<MovieResponse>

    @GET("/")
    suspend fun getMovie2(@Query("t") title: String, @Query("apikey") apikey: String = APIKEY): Response<MovieResponse>

    @GET("/")
    suspend fun getMovie3(@Query("t") title: String, @Query("apikey") apikey: String = APIKEY): MovieResponse

    @GET("/")
    suspend fun searchMovies(@Query("s") criteria:String,  @Query("apikey") apikey: String = APIKEY): Response<SearchResponse>
}

fun main() {
    val baseUrl =
        "https://www.omdbapi.com/"

    //println("Hola kotlin")

    //val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    //val okHttp = OkHttpClient.Builder().addInterceptor(logging).build()


    //val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        //.addConverterFactory(MoshiConverterFactory.create(moshi))
        .addConverterFactory(GsonConverterFactory.create())
        //.client(okHttp)
        .build()

    val api = retrofit.create(OmdbService::class.java)
    //print(api.getMovie("titanic").execute().body().toString())

    runBlocking {
        val response = api.getMovie2("titanic")
        if(response.isSuccessful){
            println(response.body())
        } else {
            println(response.errorBody())
        }

    }

    runBlocking {
        println(api.getMovie3("titanic"))
    }

    runBlocking {
        val response = api.searchMovies("titanic")

        if(response.isSuccessful){
            response.body()?.Search?.forEach {
                println(it)
            }
        } else {
            println(response.errorBody())
        }

    }


}