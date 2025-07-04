package com.rem11clienttracker.app.client_tracker
import org.springframework.http.ResponseEntity
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

@DeleteMapping("/{id}")
fun deleteClient(@PathVariable id: Long): ResponseEntity<Void> {
    if (!repository.existsById(id)) {
        return ResponseEntity.notFound().build()// “Return a 200 OK with no body.”
    }
    repository.deleteById(id)
    return ResponseEntity.ok().build()//“Return a 200 OK with no body.”
}
//spring class to customize http responses status codes and headers 
}
