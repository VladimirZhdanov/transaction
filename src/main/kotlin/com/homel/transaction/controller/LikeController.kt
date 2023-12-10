package com.homel.transaction.controller

import com.homel.transaction.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LikeController(private val userService: UserService) {

    @GetMapping("/start")
    fun start(): String {
        userService.work("Bill")
        println("controller work is finished")
        return "controller work is finished"
    }
}