package com.rsginer.hackathoon.banks.datasource.mock

import com.rsginer.hackathoon.banks.datasource.BankDataSource
import com.rsginer.hackathoon.banks.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {

    private val banks = listOf(
        Bank("12345", 0.1, 1),
        Bank("10101", 0.1, 2),
        Bank("50505", 1.0, 100)
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBank(accountNumber: String): Bank = banks.first { it.accountNumber == accountNumber }
}
