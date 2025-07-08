package com.rem11clienttracker.app.client_tracker

import jakarta.persistence.*
//imports JPA java persistence API annotations for ORM object relational mapping


@Entity //database class table
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

