package com.rsginer.hackathoon.banks.datasource.mock

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest {
   private val mockDataSource = MockBankDataSource()

   @Test
   fun `should provide a collection of banks`() {

      val banks = mockDataSource.retrieveBanks()

      assertThat(banks).isNotEmpty
      assertThat(banks.size).isGreaterThanOrEqualTo(3)
   }

   @Test
   fun `should provide some mock data`() {
      val banks = mockDataSource.retrieveBanks()

      assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
      assertThat(banks).anyMatch { it.trust != 0.0 }
      assertThat(banks).allMatch { it.transactionFee != 0 }

   }
}
