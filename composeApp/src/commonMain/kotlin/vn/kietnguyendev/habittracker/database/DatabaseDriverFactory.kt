package vn.kietnguyendev.habittracker.database

import app.cash.sqldelight.db.SqlDriver
import vn.kietnguyendev.habittracker.di.Context

expect class DatabaseDriverFactory(context: Context) {
    fun createDriver(): SqlDriver
}