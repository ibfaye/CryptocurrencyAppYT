package com.codebase.cryptocurrencyapp.domain.use_case.get_coins

import com.codebase.cryptocurrencyapp.commun.Resource
import com.codebase.cryptocurrencyapp.data.remote.dto.toCoin
import com.codebase.cryptocurrencyapp.domain.model.Coin
import com.codebase.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {

            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e:HttpException) {

            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {

            emit(Resource.Error<List<Coin>>("Couldn't reach server, Check your connection!"))
        }
    }
}