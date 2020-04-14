package com.infinity_coder.fitness_club.db

import com.infinity_coder.fitness_club.db.dao.ClientsByGroupDao
import com.infinity_coder.fitness_club.db.dao.LessonsDao
import com.infinity_coder.fitness_club.db.dao.RoomCongestionDao

object AppDatabase {
    val lessonsDao = LessonsDao()

    val roomCongestionDao = RoomCongestionDao()

    val clientsDao = ClientsByGroupDao()
}