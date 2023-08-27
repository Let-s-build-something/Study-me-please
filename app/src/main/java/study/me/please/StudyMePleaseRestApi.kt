package study.me.please

import study.me.please.data.io.BreedsListResponse
import retrofit2.Response
import retrofit2.http.GET

interface StudyMePleaseRestApi {

    @GET("breeds/list/all")
    suspend fun getAllBreeds(): Response<BreedsListResponse>
}