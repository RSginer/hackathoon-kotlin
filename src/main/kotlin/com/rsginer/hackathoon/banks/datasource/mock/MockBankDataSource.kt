package com.rsginer.hackathoon.banks.datasource.mock

import com.rsginer.hackathoon.banks.datasource.BankDataSource
import com.rsginer.hackathoon.banks.model.Bank
import org.springframework.stereotype.Repository
import java.lang.IllegalArgumentException

@Repository
class MockBankDataSource : BankDataSource {

    private val banks = mutableListOf<Bank>(
        Bank("12345", 0.1, 1),
        Bank("10101", 0.1, 2),
        Bank("50505", 1.0, 100)
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBank(accountNumber: String): Bank = banks.firstOrNull() { it.accountNumber == accountNumber }
        ?: throw NoSuchElementException("Could not find a bank with accountNumber $accountNumber")

    override fun createBank(bank: Bank): Bank {

        if (banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("Bank with accountNumber ${bank.accountNumber} already exist")
        }

        banks.add(bank)

        return bank
    }
}
