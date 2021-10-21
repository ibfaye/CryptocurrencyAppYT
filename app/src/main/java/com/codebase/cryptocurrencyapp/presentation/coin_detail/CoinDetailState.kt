package com.codebase.cryptocurrencyapp.presentation.coin_detail

import com.codebase.cryptocurrencyapp.domain.model.Coin
import com.codebase.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
