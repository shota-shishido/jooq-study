package com.example.helloworld

import nu.studer.sample.tables.Tasks
import org.jooq.*
import org.jooq.conf.Settings
import org.jooq.impl.DSL.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class HelloWorldApplication

@RestController
class HelloWorldController {


    @GetMapping("/")
    fun hello(): String {
        return "Hello, World!"
    }

    @GetMapping("/tasks")
    fun getTasks(): String {
        val url = "jdbc:postgresql://localhost:5432/postgres"
        val userName = "postgres"
        val password = "example"

        val conn = java.sql.DriverManager.getConnection(url, userName, password)

        val settings = Settings();
        settings.isExecuteLogging = true
        settings.isAttachRecords = true
        settings.withRenderFormatted(true)
        settings.withRenderSchema(true)
        settings.isDebugInfoOnStackTrace = true
        settings.isDiagnosticsLogging = true

        val jooq = using(conn, SQLDialect.POSTGRES, settings)

        val t = Tasks.TASKS

        val res = jooq
            .select(t.TITLE)
            .from(t)
            .fetch()

        println(res.get(0))

        return "tasks!!"

    }
}

fun main(args: Array<String>) {
    runApplication<HelloWorldApplication>(*args)
}