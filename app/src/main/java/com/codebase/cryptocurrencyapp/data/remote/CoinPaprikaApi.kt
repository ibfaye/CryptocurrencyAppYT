package com.codebase.cryptocurrencyapp.data.remote

import com.codebase.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.codebase.cryptocurrencyapp.data.remote.dto.CoinDto
import com.codebase.cryptocurrencyapp.domain.model.CoinDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}