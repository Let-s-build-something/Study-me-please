package study.me.please.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import study.me.please.StudyMePleaseRestApi
import java.util.concurrent.TimeUnit

@Module
@InstallIn(ActivityRetainedComponent::class)
object RestServicesModule {

    private const val BASE_URL = "https://www.balldontlie.io/api/"

    @ActivityRetainedScoped
    @Provides
    fun provideRestApi(retrofit: Retrofit): StudyMePleaseRestApi = retrofit.create(StudyMePleaseRestApi::class.java)

    /** Retrofit instance for providing API services and converting JSON to Kotlin */
    @ActivityRetainedScoped
    @Provides
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    /** Retrofit instance for connecting and requesting */
    @ActivityRetainedScoped
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().also { httpClientBuilder ->
            httpClientBuilder.retryOnConnectionFailure(true)
            httpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
            httpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
        }.build()
    }
}