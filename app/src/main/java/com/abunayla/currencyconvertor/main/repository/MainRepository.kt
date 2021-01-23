package com.abunayla.currencyconvertor.main.repository

import com.abunayla.currencyconvertor.data.models.CurrencyResponse
import com.abunayla.currencyconvertor.util.Resource

interface MainRepository {
    suspend fun getRates(base: String): Resource<CurrencyResponse>
}