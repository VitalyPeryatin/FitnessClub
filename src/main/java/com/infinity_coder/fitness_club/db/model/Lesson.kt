package com.infinity_coder.fitness_club.db.model

data class Lesson (
        val lessonType: String,
        val room: String,
        val fioTrainer: String,
        val trainerPhoneNumber: String,
        val startTime: String,
        val endTime: String
)