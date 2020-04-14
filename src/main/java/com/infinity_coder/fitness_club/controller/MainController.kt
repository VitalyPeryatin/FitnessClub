package com.infinity_coder.fitness_club.controller

import com.infinity_coder.fitness_club.controller._common.openStage
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.stage.Stage


class MainController {

    @FXML
    private val openLessonsButton: Button? = null

    @FXML
    private val openClientsByGroupButton: Button? = null

    @FXML
    private val openRoomCongestionButton: Button? = null

    @FXML
    private fun initialize() {
    }

    @FXML
    fun openClientsByGroup(event: ActionEvent?) {
        val root: Parent = FXMLLoader.load(javaClass.classLoader.getResource("com/infinity_coder/fitness_club/views/clients_by_group.fxml"))
        openStage("com/infinity_coder/fitness_club/views/clients_by_group.fxml", "Клиенты по группам")
    }

    @FXML
    fun openLessons(event: ActionEvent?) {
        openStage("com/infinity_coder/fitness_club/views/lessons.fxml", "Занятия")
    }

    @FXML
    fun openRoomCongestion(event: ActionEvent?) {
        openStage("com/infinity_coder/fitness_club/views/room_congestion.fxml", "Загруженность залов")
    }
}

