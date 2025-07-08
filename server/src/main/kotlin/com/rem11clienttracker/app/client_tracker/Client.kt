package com.rem11clienttracker.app.client_tracker 
//package file belogns to,,,helps organize code avoid name errors
import jakarta.persistence.*
//classes and annotations from the jakarta package
//imports JPA java persistence API annotations for ORM object relational mapping


@Entity //database class,,,client is now database entity
@Table(name = "clients")
//database name

data class Client(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    //identity strategy the database auto generates the id for each new client
    //sequence generation types are ways JPA can auto generate unique IDs for your entities
    //constants variables
    val id: Long = 0,
    val name: String,
    val email: String
)

