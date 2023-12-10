package com.homel.transaction.service

import com.homel.transaction.dao.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional

@Service
class UserUpdateServiceImpl(private val userRepository: UserRepository): UserUpdateService {

    @Transactional(isolation = Isolation.READ_COMMITTED)
    override fun updateLikes(name: String) {
        println("start task on ${Thread.currentThread().name}")
        val userEntity = userRepository.findByName(name)
        userEntity?.let {
            it.likes = it.likes + 1
        }
        println("finished task on ${Thread.currentThread().name}")
    }
}