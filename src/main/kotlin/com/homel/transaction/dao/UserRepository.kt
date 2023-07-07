package com.homel.transaction.dao

import com.homel.transaction.model.User
import jakarta.persistence.LockModeType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Lock

interface UserRepository: JpaRepository<User, Int>, JpaSpecificationExecutor<User>{
    //@Lock(LockModeType.PESSIMISTIC_WRITE)
    fun findByName(name: String): User?
}