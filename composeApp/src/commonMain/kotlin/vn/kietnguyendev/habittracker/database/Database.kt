package vn.kietnguyendev.habittracker.database

import app.cash.sqldelight.ColumnAdapter
import vn.kietnguyendev.habittracker.domain.model.Habit
import database.Habit as HabitDatabase

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val completedDatesAdapter = object : ColumnAdapter<List<Long>, String> {
        override fun decode(databaseValue: String): List<Long> =
            if (databaseValue.isEmpty()) listOf() else databaseValue.split(",")
                .map { it.toLong() }

        override fun encode(value: List<Long>) = value.joinToString(separator = ",")
    }
    private val database =
        AppDatabase(driver = databaseDriverFactory.createDriver(), HabitAdapter = HabitDatabase.Adapter(completedDatesAdapter = completedDatesAdapter))
    private val dbQuery = database.appDatabaseQueries

    internal fun getAllHabits(): List<Habit> {
        return dbQuery.selectAllHabits(::mapHabitSelecting).executeAsList()
    }

    internal fun insertHabit(habit: Habit) {
        habit.apply {
            dbQuery.insertHabit(
                name = name,
                description = description,
                startDate = startDate,
                endDate = endDate,
                frequency = frequency,
                reminderTime = reminderTime,
                steak = steak,
                completedDates = completedDates,
                color = color,
                icon = icon
            )
        }
    }

    internal fun removeHabit(id: Long) {
        dbQuery.removeHabitById(id)
    }

    private fun mapHabitSelecting(
        id: Long,
        name: String,
        description: String?,
        startDate: Long,
        endDate: Long?,
        frequency: String,
        reminderTime: Long?,
        steak: Long,
        completedDates: List<Long>,
        color: String,
        icon: String
    ): Habit {
        return Habit(
            id = id,
            name = name,
            description = description,
            startDate = startDate,
            endDate = endDate,
            frequency = frequency,
            reminderTime = reminderTime,
            steak = steak,
            completedDates = completedDates,
            color = color,
            icon = icon
        )
    }
}