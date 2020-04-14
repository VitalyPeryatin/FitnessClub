package com.infinity_coder.fitness_club.db.dao

import com.infinity_coder.fitness_club.db.DatabaseHelper
import com.infinity_coder.fitness_club.db.FitnessClubDatabaseHelper
import com.infinity_coder.fitness_club.db.model.Lesson
import java.sql.SQLException
import java.text.SimpleDateFormat
import java.util.*

class LessonsDao : DatabaseHelper by FitnessClubDatabaseHelper() {

    private val dateFormat = SimpleDateFormat("HH:mm")

    fun getLessons(): List<Lesson> {
        val selectQuery = "SELECT * FROM timetable LEFT JOIN coach ON timetable.coach_id = coach.id;"
        val statement = getDbConnection().createStatement()
        val lessons = mutableListOf<Lesson>()
        try {
            val resultSet = statement.executeQuery(selectQuery)
            while (resultSet.next()) {
                val lessonType = resultSet.getString("type")
                val room = resultSet.getString("room")
                val fioTrainer = resultSet.getString("full_name")
                val trainerPhoneNumber = resultSet.getString("phone_number")
                val startTime = resultSet.getTime("start_time")
                val durationTime = resultSet.getTime("duration")
                val durationCalendar = Calendar.getInstance().apply {
                    time = durationTime
                }

                val startDate = Calendar.getInstance().apply {
                    time = startTime
                }.time

                val endDate = Calendar.getInstance().apply {
                    time = startTime
                    add(Calendar.HOUR, durationCalendar.get(Calendar.HOUR))
                    add(Calendar.MINUTE, durationCalendar.get(Calendar.MINUTE))
                }.time

                val startTimeString = dateFormat.format(startDate)
                val endTimeString = dateFormat.format(endDate)

                val lesson = Lesson(
                        lessonType = lessonType,
                        room = room,
                        fioTrainer = fioTrainer,
                        trainerPhoneNumber = trainerPhoneNumber,
                        startTime = startTimeString,
                        endTime = endTimeString
                )
                lessons.add(lesson)
            }
        } catch (e: SQLException) {
        } finally {
            statement.close()
        }
        return lessons
    }
}