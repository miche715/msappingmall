package com.sangseng.msappingmallgateway.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GatewayConfiguration {
    @Value("\${context-path-gateway:/}")
    lateinit var gatewayContextPath: String
    @Value("\${context-path-user:/}")
    lateinit var userContextPath: String
    @Value("\${context-path-product:/}")
    lateinit var productContextPath: String
    @Value("\${context-path-order:/}")
    lateinit var orderContextPath: String

    @Bean
    fun routeLocator(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
                      .route("user-service") { route ->
                          route.path("/${gatewayContextPath}/${userContextPath}/**")
                               .filters() { filter ->
                                   filter.rewritePath("/${gatewayContextPath}/${userContextPath}/(?<segment>.*)", "/${userContextPath}/\${segment}")
                               }.uri("http://localhost:13435")
                      }
                      .route("product-service") { route ->
                          route.path("/${gatewayContextPath}/${productContextPath}/**")
                               .filters() { filter ->
                                   filter.rewritePath("/${gatewayContextPath}/${productContextPath}/(?<segment>.*)", "/${productContextPath}/\${segment}")
                               }.uri("http://localhost:13436")
                      }
                      .route("order-service") { route ->
                          route.path("/${gatewayContextPath}/${orderContextPath}/**")
                               .filters() { filter ->
                                   filter.rewritePath("/${gatewayContextPath}/${orderContextPath}/(?<segment>.*)", "/${orderContextPath}/\${segment}")
                               }.uri("http://localhost:13437")
                      }
                      .build()
    }
}