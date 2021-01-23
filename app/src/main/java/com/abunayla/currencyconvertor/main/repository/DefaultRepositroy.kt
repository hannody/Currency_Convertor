package com.abunayla.currencyconvertor.main.repository

import com.abunayla.currencyconvertor.data.CurrencyApi
import com.abunayla.currencyconvertor.data.models.CurrencyResponse
import com.abunayla.currencyconvertor.util.Resource
import java.lang.Exception
import javax.inject.Inject

class DefaultRepositroy @Inject constructor(
    private val api: CurrencyApi
): MainRepository{
    override suspend fun getRates(base: String): Resource<CurrencyResponse> {
        return try{
            val response = api.getRates(base)
            val result = response.body()
            if (response.isSuccessful && result!= null){
                Resource.Success(result)
            } else{
                Resource.Error(response.message())
            }
        }
        catch (e: Exception){
            Resource.Error(e.message?: "An error occurred")
        }
    }

}