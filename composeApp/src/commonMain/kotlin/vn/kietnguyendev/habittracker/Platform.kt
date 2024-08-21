package vn.kietnguyendev.habittracker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform