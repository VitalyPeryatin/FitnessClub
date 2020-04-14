package com.infinity_coder.fitness_club.db

import com.infinity_coder.fitness_club.BuildConfig
import java.sql.Connection
import java.sql.DriverManager


class FitnessClubDatabaseHelper : DatabaseHelper {
    private lateinit var dbConnection: Connection

    override fun getDbConnection(): Connection {
        val connectionString = "jdbc:postgresql://${BuildConfig.dbHost}:${BuildConfig.dbPort}/${BuildConfig.dbName}"
        Class.forName("org.postgresql.Driver")

        dbConnection = DriverManager.getConnection(connectionString, BuildConfig.dbUser, BuildConfig.dbPass)
        return dbConnection
    }
}