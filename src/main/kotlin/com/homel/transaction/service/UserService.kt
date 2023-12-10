package com.homel.transaction.service

import org.springframework.stereotype.Service

@Service
class UserService(
    private val asyncService: AsyncService
) {
    fun work(name: String) {
        println("start work on ${Thread.currentThread().name}")
        for (i in 1..TASK_SIZE) {
            asyncService.runTask(name)
        }
        println("finished work on ${Thread.currentThread().name}")
    }

    companion object {
        private const val TASK_SIZE: Int = 100
    }
}