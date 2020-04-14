package com.infinity_coder.fitness_club.controller._common

import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

fun Any.openStage(path: String, title: String) {
    val root: Parent = FXMLLoader.load(javaClass.classLoader.getResource(path))
    val stage = Stage()
    stage.title = title
    stage.scene = Scene(root, 1000.0, 700.0)
    stage.show()
}