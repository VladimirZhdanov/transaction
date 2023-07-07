package com.homel.transaction

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.retry.annotation.EnableRetry
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
@EnableRetry
class TransactionApplication

fun main(args: Array<String>) {
	runApplication<TransactionApplication>(*args)
}
