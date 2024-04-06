package study.me.please.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object RestApiModule {

    private const val BASE_URL = "https://study-me-please.com"

    @Singleton
    @Provides
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().also { httpClientBuilder ->
            httpClientBuilder.retryOnConnectionFailure(true)
            httpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
            httpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
        }.build()
    }
}