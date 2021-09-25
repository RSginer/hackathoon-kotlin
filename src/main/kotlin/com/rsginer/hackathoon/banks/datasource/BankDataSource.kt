package com.rsginer.hackathoon.banks.datasource

import com.rsginer.hackathoon.banks.model.Bank

interface BankDataSource {
    fun retrieveBanks(): Collection<Bank>
    fun retrieveBank(accountNumber: String): Bank
}
