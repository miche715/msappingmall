package com.sangseng.msappingmalluserserver.api.sign.controller

import com.sangseng.msappingmalluserserver.api.sign.dto.SignInRequestDTO
import com.sangseng.msappingmalluserserver.api.sign.dto.SignInResponseDTO
import com.sangseng.msappingmalluserserver.api.sign.dto.SignUserDTO
import com.sangseng.msappingmalluserserver.api.sign.service.SignService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SignController(@Autowired private val signService: SignService) {
    @PostMapping("/sign-in")
    fun signIn(@RequestBody signInRequestDTO: SignInRequestDTO): ResponseEntity<SignInResponseDTO> {
        return ResponseEntity.ok(signService.signIn(signInRequestDTO).let() { signUserDTO ->
            SignInResponseDTO(signUserDTO.id, signUserDTO.password)
        })
    }
}