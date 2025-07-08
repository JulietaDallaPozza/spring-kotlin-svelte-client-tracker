// file that starts backend,,,launches whole app
package com.rem11clienttracker.app.client_tracker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// function starts spring boot app

@SpringBootApplication class ClientTrackerApplication
// main entry point of app,,,set up

fun main(args: Array<String>) {
    runApplication<ClientTrackerApplication>(*args)
    // standart main function to start the app
}
