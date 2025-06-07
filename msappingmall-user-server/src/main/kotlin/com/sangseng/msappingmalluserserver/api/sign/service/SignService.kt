package com.sangseng.msappingmalluserserver.api.sign.service

import com.sangseng.msappingmalluserserver.api.sign.dto.SignInRequestDTO
import com.sangseng.msappingmalluserserver.api.sign.dto.SignUserDTO
import com.sangseng.msappingmalluserserver.api.sign.mapper.SignMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SignService(@Autowired private val signMapper: SignMapper) {
    fun signIn(signInRequestDTO: SignInRequestDTO): SignUserDTO {
        return signMapper.selectUser(signInRequestDTO)
            ?: SignUserDTO("aa", "aa")
    }
}