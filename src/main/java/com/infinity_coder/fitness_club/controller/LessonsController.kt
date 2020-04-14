package com.infinity_coder.fitness_club.controller

import com.infinity_coder.fitness_club.db.AppDatabase
import com.infinity_coder.fitness_club.db.model.Lesson
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory


class LessonsController {

    @FXML
    private lateinit var tableView: TableView<Lesson>

    @FXML
    private lateinit var lessonsTypeColumn: TableColumn<Lesson, String>

    @FXML
    private lateinit var roomColumn: TableColumn<Lesson, String>

    @FXML
    private lateinit var fioTrainerColumn: TableColumn<Lesson, String>

    @FXML
    private lateinit var trainerPhoneNumberColumn: TableColumn<Lesson, String>

    @FXML
    private lateinit var startTimeColumn: TableColumn<Lesson, String>

    @FXML
    private lateinit var endTimeColumn: TableColumn<Lesson, String>

    @FXML
    private fun initialize() {
        lessonsTypeColumn.cellValueFactory = PropertyValueFactory<Lesson, String>("lessonType")
        roomColumn.cellValueFactory = PropertyValueFactory<Lesson, String>("room")
        fioTrainerColumn.cellValueFactory = PropertyValueFactory<Lesson, String>("fioTrainer")
        trainerPhoneNumberColumn.cellValueFactory = PropertyValueFactory<Lesson, String>("trainerPhoneNumber")
        startTimeColumn.cellValueFactory = PropertyValueFactory<Lesson, String>("startTime")
        endTimeColumn.cellValueFactory = PropertyValueFactory<Lesson, String>("endTime")

        tableView.items = getLessons()
    }

    private fun getLessons(): ObservableList<Lesson> {
        val lessonsDao = AppDatabase.lessonsDao
        return FXCollections.observableList(lessonsDao.getLessons())
    }
}