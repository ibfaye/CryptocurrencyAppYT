package com.codebase.cryptocurrencyapp.presentation.coin_list

import com.codebase.cryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
