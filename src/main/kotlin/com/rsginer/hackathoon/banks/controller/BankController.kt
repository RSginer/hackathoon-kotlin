package com.rsginer.hackathoon.banks.controller

import com.rsginer.hackathoon.banks.model.Bank
import com.rsginer.hackathoon.banks.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/banks")
class BankController(
    private val bankService: BankService
) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @GetMapping
    fun getBanks(): Collection<Bank> = this.bankService.getBanks()

    @GetMapping("/{accountNumber}")
    fun getBankByAccountNumber(@PathVariable accountNumber: String): Bank  = this.bankService.getBank(accountNumber)

}
