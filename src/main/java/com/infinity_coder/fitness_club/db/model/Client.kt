package com.infinity_coder.fitness_club.db.model

data class Client(
        val number: Int,
        val fullName: String,
        val gender: String,
        val weight: Float,
        val height: Float,
        val startOfSubscription: String,
        val endOfSubscription: String,
        val phoneNumber: String
)