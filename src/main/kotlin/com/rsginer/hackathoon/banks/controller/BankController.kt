package com.rsginer.hackathoon.banks.controller

import com.rsginer.hackathoon.banks.model.Bank
import com.rsginer.hackathoon.banks.service.BankService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/banks")
class BankController(
    private val bankService: BankService
) {

    @GetMapping
    fun getBanks(): Collection<Bank> = this.bankService.getBanks()

    @GetMapping("/{accountNumber}")
    fun getBankByAccountNumber(@PathVariable accountNumber: String): Bank {
        return this.bankService.getBank(accountNumber)
    }
}
