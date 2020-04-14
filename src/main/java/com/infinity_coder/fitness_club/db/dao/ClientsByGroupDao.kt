package com.infinity_coder.fitness_club.db.dao

import com.infinity_coder.fitness_club.db.DatabaseHelper
import com.infinity_coder.fitness_club.db.FitnessClubDatabaseHelper
import com.infinity_coder.fitness_club.db.model.Client
import java.sql.SQLException
import java.text.SimpleDateFormat

class ClientsByGroupDao : DatabaseHelper by FitnessClubDatabaseHelper() {

    private val dateFormatter = SimpleDateFormat("yyyy.MM.dd")

    fun getClients(groupName: String, searchQuery: String = ""): List<Client> {
        val selectQuery = "SELECT subscription_num, full_name, gender, weight, height, subs_start_date, subs_end_date, phone_number FROM client WHERE group_name = \'$groupName\' AND full_name LIKE '%$searchQuery%';"
        val statement = getDbConnection().createStatement()
        val clients = mutableListOf<Client>()
        try {
            val resultSet = statement.executeQuery(selectQuery)
            while (resultSet.next()) {

                val startTimeOfSubscription = resultSet.getTime("subs_start_date")
                val endTimeOfSubscription = resultSet.getTime("subs_end_date")

                val client = Client(
                        number = resultSet.getInt("subscription_num"),
                        fullName = resultSet.getString("full_name"),
                        gender = resultSet.getString("gender"),
                        weight = resultSet.getFloat("weight"),
                        height = resultSet.getFloat("height"),
                        startOfSubscription = dateFormatter.format(startTimeOfSubscription),
                        endOfSubscription = dateFormatter.format(endTimeOfSubscription),
                        phoneNumber = resultSet.getString("phone_number")
                )
                clients.add(client)
            }
        } catch (e: SQLException) {
            print("")
        } finally {
            statement.close()
        }
        return clients
    }

    fun getAllGroups(): List<String> {
        val selectQuery = "SELECT DISTINCT ON (name) name from fitness_group;"
        val statement = getDbConnection().createStatement()
        val groups = mutableListOf<String>()
        try {
            val resultSet = statement.executeQuery(selectQuery)
            while (resultSet.next()) {
                val roomName = resultSet.getString("name")
                groups.add(roomName)
            }
        } catch (e: SQLException) {
        } finally {
            statement.close()
        }
        return groups
    }
}