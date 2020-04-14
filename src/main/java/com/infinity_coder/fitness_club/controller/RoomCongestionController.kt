package com.infinity_coder.fitness_club.controller

import com.infinity_coder.fitness_club.db.AppDatabase
import com.infinity_coder.fitness_club.db.model.RoomCongestion
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.text.Text
import java.awt.event.ActionEvent


class RoomCongestionController {

    @FXML
    private lateinit var tableView: TableView<RoomCongestion>

    @FXML
    private lateinit var dayOfWeekColumn: TableColumn<RoomCongestion, String>

    @FXML
    private lateinit var timeColumn: TableColumn<RoomCongestion, String>

    @FXML
    private lateinit var roomNumberTextView: Text

    @FXML
    private lateinit var currentRoomTextView: Text

    private val roomCongestionDao = AppDatabase.roomCongestionDao

    private var roomNames = listOf<String>()
    private var currentRoomIndex = 0

    @FXML
    private fun initialize() {
        dayOfWeekColumn.cellValueFactory = PropertyValueFactory<RoomCongestion, String>("dayOfWeek")
        timeColumn.cellValueFactory = PropertyValueFactory<RoomCongestion, String>("time")

        loadAllRooms()
        loadDefaultRoomCongestion()
    }

    @FXML
    fun loadNextRoomCongestion() {
        val nextRoomIndex = currentRoomIndex + 1
        if (nextRoomIndex < roomNames.size) {
            currentRoomIndex = nextRoomIndex
            loadCurrentRoomCongestion()
        }
    }

    @FXML
    fun loadPrevRoomCongestion() {
        val prevRoomIndex = currentRoomIndex - 1
        if (prevRoomIndex >= 0) {
            currentRoomIndex = prevRoomIndex
            loadCurrentRoomCongestion()
        }
    }

    private fun loadDefaultRoomCongestion() {
        currentRoomIndex = 0
        if (roomNames.isNotEmpty()) {
            loadCurrentRoomCongestion()
        }
    }

    private fun loadCurrentRoomCongestion() {
        val roomName = roomNames[currentRoomIndex]
        currentRoomTextView.text = roomName
        roomNumberTextView.text = "Room (${currentRoomIndex + 1} of ${roomNames.size})"
        val roomCongestion = FXCollections.observableList(roomCongestionDao.getRoomCongestion(roomName))
        tableView.items = roomCongestion
    }

    private fun loadAllRooms() {
        roomNames = roomCongestionDao.getAllRooms()
    }
}