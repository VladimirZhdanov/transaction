package com.homel.transaction.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Version

@Entity
@Table(name = "user_table")
data class User(
    @Id val id: Long,
    @Column(name = "name") val name: String,
    @Column(name = "likes") var likes: Int,
    @Version val version: Int,
)