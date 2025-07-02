package com.rem11clienttracker.app.client_tracker

import org.springframework.web.bind.annotation.*
//Model-View-Controller**design pattern used to organize and structure on spring framework

@RestController
//rest controller class**handles http request returns JSON
@RequestMapping("/api/clients")
//base url for all endpoints
class ClientController(private val repository: ClientRepository) {
    //accses to the database 

    @GetMapping
    fun getAllClients() = repository.findAll()
    //GET request to api clientss and return

    @PostMapping    //POST request to api clients
    fun addClient(@RequestBody client: Client) = repository.save(client) //save new clients as json in database and returns 
}
