package com.rem11clienttracker.app.client_tracker 
//package file belogns to,,,helps organize code avoid name errors
import jakarta.persistence.*
//classes and annotations from the jakarta package
//jakarta set of software components, APIs, for developing  entrepiseJava apps"
//imports JPA "java persistence API annotations" for ORM "object relational mapping"


//object relational mapping technique to store and retrieve info from databases easily
//to connect objects in code and tables in databases,,, orm acts a translator between a program
//that uses objects and the database that uses tables 


@Entity //mark a class as an entity, indicating it shud persist in a database 
//class that i meant to be saved in database 
//class is a definition of structure and behavior mehotds and variables of objects (attributes)(a plan/recipe)
@Table(name = "clients")
//table specifies details about the database table associated with the entity


//data is a class that holds data. automatically kotlin provides useful methods 
data class Client(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    //identity strategy the database auto generates the id for each new client
    //sequence generation types are ways JPA can auto generate unique IDs for your entities
    //constants variables
    val id: Long = 0,
    val name: String,
    val email: String
)

