package com.infinity_coder.fitness_club.db

import java.sql.Connection

interface DatabaseHelper {
    fun getDbConnection(): Connection
}