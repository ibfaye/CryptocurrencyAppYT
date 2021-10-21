package com.codebase.cryptocurrencyapp.data.repository

import com.codebase.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.codebase.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.codebase.cryptocurrencyapp.data.remote.dto.CoinDto
import com.codebase.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinPaprikaApi): CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}