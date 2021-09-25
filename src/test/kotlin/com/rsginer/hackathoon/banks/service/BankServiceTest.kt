package com.rsginer.hackathoon.banks.service

import com.rsginer.hackathoon.banks.datasource.BankDataSource
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class BankServiceTest {

    private val bankDatasource: BankDataSource = mockk(relaxed = true)
    private val bankService = BankService(bankDatasource)

    @Test
    fun `should call its data source to retrieve banks`() {
        bankService.getBanks()

        verify(exactly = 1) { bankDatasource.retrieveBanks() }
    }
}
