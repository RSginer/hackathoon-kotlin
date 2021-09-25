package com.rsginer.hackathoon.banks.service

import com.rsginer.hackathoon.banks.datasource.BankDataSource
import com.rsginer.hackathoon.banks.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(
    private val dataSource: BankDataSource
) {
    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()
}
