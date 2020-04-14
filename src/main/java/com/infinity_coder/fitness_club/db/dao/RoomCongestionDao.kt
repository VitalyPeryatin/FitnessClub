package com.infinity_coder.fitness_club.db.dao

import com.infinity_coder.fitness_club.db.DatabaseHelper
import com.infinity_coder.fitness_club.db.FitnessClubDatabaseHelper
import com.infinity_coder.fitness_club.db.model.RoomCongestion
import java.sql.SQLException
import java.text.SimpleDateFormat

class RoomCongestionDao : DatabaseHelper by FitnessClubDatabaseHelper() {

    private val dateFormat = SimpleDateFormat("HH:mm")

    fun getRoomCongestion(roomName: String): List<RoomCongestion> {
        val selectQuery = "SELECT room, day_of_week, sum(duration) hours from timetable WHERE room = \'$roomName\' GROUP BY room, day_of_week;"
        val statement = getDbConnection().createStatement()
        val rooms = mutableListOf<RoomCongestion>()
        try {
            val resultSet = statement.executeQuery(selectQuery)
            while (resultSet.next()) {
                val dayOfWeek = resultSet.getString("day_of_week")
                val congestionTime = resultSet.getTime("hours")

                val roomCongestion = RoomCongestion(
                        dayOfWeek = dayOfWeek,
                        time = dateFormat.format(congestionTime)
                )
                rooms.add(roomCongestion)
            }
        } catch (e: SQLException) {
        } finally {
            statement.close()
        }
        return rooms
    }

    fun getAllRooms(): List<String> {
        val selectQuery = "SELECT DISTINCT ON (room) room from timetable;"
        val statement = getDbConnection().createStatement()
        val rooms = mutableListOf<String>()
        try {
            val resultSet = statement.executeQuery(selectQuery)
            while (resultSet.next()) {
                val roomName = resultSet.getString("room")
                rooms.add(roomName)
            }
        } catch (e: SQLException) {
        } finally {
            statement.close()
        }
        return rooms
    }
}