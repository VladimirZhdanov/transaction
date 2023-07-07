package com.homel.transaction.service

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class AsyncService(private val userUpdateService: UserUpdateService) {

    @Async
    fun task(name: String) {
        userUpdateService.updateLikes(name)
    }
}
