package com.homel.transaction.service

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class AsyncService(
    private val userUpdateServiceImpl: UserUpdateService,
    //private val userUpdateServiceRetry: UserUpdateService,
    ) {

    @Async
    fun runTask(name: String) {
        userUpdateServiceImpl.updateLikes(name)
    }
}
