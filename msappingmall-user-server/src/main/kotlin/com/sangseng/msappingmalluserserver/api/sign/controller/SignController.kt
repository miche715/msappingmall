package com.sangseng.msappingmalluserserver.api.sign.controller

import com.sangseng.msappingmalluserserver.api.sign.service.SignService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SignController(@Autowired private val signService: SignService) {
    @PostMapping("/sign-in")
    fun singIn(echo: String): String {
        return echo
    }
}