//controler handles API request
package com.rem11clienttracker.app.client_tracker

import org.springframework.http.ResponseEntity
//class for http response 
import org.springframework.web.bind.annotation.*
//import annotations use to define rest endpoints (Annotations are used to provide supplemental information about a program metadata information)

// Model-View-Controller**design pattern used to organize and structure on spring framework

@RestController
// rest controller class**handles http request returns JSON
@RequestMapping("/api/clients")
// base url for all endpoints
class ClientController(private val repository: ClientRepository) {
    //val = variables in kotlin
    // gives this controller accses to the database

    @GetMapping fun getAllClients() = repository.findAll()
    // GET request to api clientss and return
    //we could use POST for safety purposes as POST sends the data in the request body (keeps data hidden)
    //use post as well when search is too complex for the url

    @PostMapping // POST request to api clients
    fun addClient(@RequestBody client: Client) =
            repository.save(client) // save new clients as json in database and returns

    @DeleteMapping("/{id}")
    fun deleteClient(@PathVariable id: Long): ResponseEntity<Void> {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build() //not found sets the response type,,,build finalizes (method)
        }
        repository.deleteById(id)
        return ResponseEntity.ok().build() 
    }
    // spring class to customize http responses status codes and headers
}