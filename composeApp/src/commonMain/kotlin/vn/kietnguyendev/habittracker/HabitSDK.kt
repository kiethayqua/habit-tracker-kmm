package vn.kietnguyendev.habittracker

import vn.kietnguyendev.habittracker.database.Database
import vn.kietnguyendev.habittracker.database.DatabaseDriverFactory

class HabitSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
}