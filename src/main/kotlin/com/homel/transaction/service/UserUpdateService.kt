package com.homel.transaction.service

import com.homel.transaction.dao.UserRepository
import org.springframework.retry.annotation.Retryable
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional

@Service
class UserUpdateService(private val userRepository: UserRepository) {

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Retryable(maxAttempts = 10)
    fun updateLikes(name: String) {
        println("start task on ${Thread.currentThread().name}")
        val userEntity = userRepository.findByName(name)
        userEntity?.let {
            it.likes = it.likes + 1
        }
        println("finished task on ${Thread.currentThread().name}")
    }
}