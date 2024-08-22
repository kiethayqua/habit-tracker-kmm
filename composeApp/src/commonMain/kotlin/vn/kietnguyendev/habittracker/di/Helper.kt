package vn.kietnguyendev.habittracker.di

import org.koin.core.context.startKoin

fun initKoin(context: Context) {
    startKoin {
        modules(appModule(context))
    }
}