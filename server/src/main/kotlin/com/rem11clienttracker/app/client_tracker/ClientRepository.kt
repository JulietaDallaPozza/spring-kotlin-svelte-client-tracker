//bridge between app and database,,,file thatc connect the app
//to the database for client objects

package com.rem11clienttracker.app.client_tracker

import org.springframework.data.jpa.repository.JpaRepository
//spring data interface provides methods for working with databases (rest)
import org.springframework.stereotype.Repository
//imports spring data JPA interfaces and annotations

@Repository
//tells spring this interface is a repo databse accsess layer 
interface ClientRepository : JpaRepository<Client, Long>
//client is the entity(type of object)
//:means it extends inherits from jpa repo
//by extending you get methods findall findbyid save delete 