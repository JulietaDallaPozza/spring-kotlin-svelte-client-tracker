package com.rem11clienttracker.app.client_tracker

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    @GetMapping("/test")
    fun hello() = "Hola from backend!"
}