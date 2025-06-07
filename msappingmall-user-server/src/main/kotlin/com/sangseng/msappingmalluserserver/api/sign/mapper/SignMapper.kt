package com.sangseng.msappingmalluserserver.api.sign.mapper

import com.sangseng.msappingmalluserserver.api.sign.dto.SignInRequestDTO
import com.sangseng.msappingmalluserserver.api.sign.dto.SignUserDTO
import org.apache.ibatis.annotations.Mapper

@Mapper
interface SignMapper {
    fun selectUser(signInRequestDTO: SignInRequestDTO): SignUserDTO?
}