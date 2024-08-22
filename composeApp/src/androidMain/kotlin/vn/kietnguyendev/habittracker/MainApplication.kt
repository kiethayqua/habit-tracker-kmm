package vn.kietnguyendev.habittracker

import android.app.Application
import vn.kietnguyendev.habittracker.di.initKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(this)
    }
}