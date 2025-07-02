package com.rem11clienttracker.app.client_tracker

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
//imports spring data JPA interfaces and annotations

@Repository
//interface spring repo ??
interface ClientRepository : JpaRepository<Client, Long>
//declares a repo for client database with long as the ID type
// CrudRepository is a Spring Data interface for generic CRUD operations on a repositoryof specific type.