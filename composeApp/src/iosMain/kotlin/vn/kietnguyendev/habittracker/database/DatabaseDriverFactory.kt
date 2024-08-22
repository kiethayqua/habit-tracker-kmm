package vn.kietnguyendev.habittracker.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import vn.kietnguyendev.habittracker.di.Context

actual class DatabaseDriverFactory actual constructor(context: Context){
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, "habit.db")
    }
}