package vn.kietnguyendev.habittracker.di

import org.koin.dsl.module
import vn.kietnguyendev.habittracker.HabitSDK
import vn.kietnguyendev.habittracker.database.DatabaseDriverFactory

fun appModule(context: Context) = module {
    single<HabitSDK> {
        HabitSDK(databaseDriverFactory = DatabaseDriverFactory(context))
    }
}