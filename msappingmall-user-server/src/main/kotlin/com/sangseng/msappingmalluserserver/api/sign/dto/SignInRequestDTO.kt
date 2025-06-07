package com.sangseng.msappingmalluserserver.api.sign.dto

data class SignInRequestDTO(
    var id: String,  // private val로 선언하면 jackson이 직렬화를 못시킴. val도 매핑 안되거나 별로 좋지 못한 일이 생길 수 있음.
    var password: String
) {

}