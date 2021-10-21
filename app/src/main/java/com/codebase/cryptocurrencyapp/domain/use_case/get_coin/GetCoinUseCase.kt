package com.codebase.cryptocurrencyapp.domain.use_case.get_coin

import com.codebase.cryptocurrencyapp.commun.Resource
import com.codebase.cryptocurrencyapp.data.remote.dto.toCoin
import com.codebase.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.codebase.cryptocurrencyapp.domain.model.Coin
import com.codebase.cryptocurrencyapp.domain.model.CoinDetail
import com.codebase.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {

            emit(Resource.Loading())
            val coins = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coins))
        } catch (e:HttpException) {

            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {

            emit(Resource.Error<CoinDetail>("Couldn't reach server, Check your connection!"))
        }
    }
}