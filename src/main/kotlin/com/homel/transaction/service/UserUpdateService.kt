package com.homel.transaction.service

import com.homel.transaction.dao.UserRepository
import org.springframework.retry.annotation.Retryable
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional

@Service
interface UserUpdateService {
    fun updateLikes(name: String)
}