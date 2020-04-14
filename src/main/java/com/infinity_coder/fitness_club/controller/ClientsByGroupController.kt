package com.infinity_coder.fitness_club.controller

import com.infinity_coder.fitness_club.db.AppDatabase
import com.infinity_coder.fitness_club.db.model.Client
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.text.Text


class ClientsByGroupController {
    @FXML
    private lateinit var tableView: TableView<Client>

    @FXML
    private lateinit var numberSubscriptionColumn: TableColumn<Client, Int>

    @FXML
    private lateinit var fioColumn: TableColumn<Client, String>

    @FXML
    private lateinit var startDateSubsColumn: TableColumn<Client, String>

    @FXML
    private lateinit var endDateSubsColumn: TableColumn<Client, String>

    @FXML
    private lateinit var phoneNumberColumn: TableColumn<Client, String>

    @FXML
    private lateinit var groupNumberTextView: Text

    @FXML
    private lateinit var currentGroupTextView: Text

    @FXML
    private lateinit var clientNameEditText: TextField

    private val clientsDao = AppDatabase.clientsDao

    private var groupNames = listOf<String>()
    private var currentGroupIndex = 0

    @FXML
    private fun initialize() {
        numberSubscriptionColumn.cellValueFactory = PropertyValueFactory<Client, Int>("number")
        fioColumn.cellValueFactory = PropertyValueFactory<Client, String>("fullName")
        startDateSubsColumn.cellValueFactory = PropertyValueFactory<Client, String>("startOfSubscription")
        endDateSubsColumn.cellValueFactory = PropertyValueFactory<Client, String>("endOfSubscription")
        phoneNumberColumn.cellValueFactory = PropertyValueFactory<Client, String>("phoneNumber")

        loadAllGroups()
        loadDefaultClients()
    }

    @FXML
    fun loadNextGroup() {
        val nextGroupIndex = currentGroupIndex + 1
        if (nextGroupIndex < groupNames.size) {
            currentGroupIndex = nextGroupIndex
            loadCurrentClients()
        }
    }

    @FXML
    fun loadPrevGroup() {
        val prevGroupIndex = currentGroupIndex - 1
        if (prevGroupIndex >= 0) {
            currentGroupIndex = prevGroupIndex
            loadCurrentClients()
        }
    }

    private fun loadDefaultClients() {
        currentGroupIndex = 0
        if (groupNames.isNotEmpty()) {
            loadCurrentClients()
        }
    }

    private fun loadCurrentClients() {
        clientNameEditText.clear()
        val groupName = groupNames[currentGroupIndex]
        currentGroupTextView.text = groupName
        groupNumberTextView.text = "Group (${currentGroupIndex + 1} of ${groupNames.size})"
        val roomCongestion = FXCollections.observableList(clientsDao.getClients(groupName))
        tableView.items = roomCongestion
    }

    private fun loadAllGroups() {
        groupNames = clientsDao.getAllGroups()
    }

    @FXML
    fun searchClients() {
        val groupName = groupNames[currentGroupIndex]
        val query = clientNameEditText.text.toString()
        val roomCongestion = FXCollections.observableList(clientsDao.getClients(groupName, query))
        tableView.items = roomCongestion
    }

}