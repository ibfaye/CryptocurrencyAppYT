package com.codebase.cryptocurrencyapp.domain.repository

import com.codebase.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.codebase.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}