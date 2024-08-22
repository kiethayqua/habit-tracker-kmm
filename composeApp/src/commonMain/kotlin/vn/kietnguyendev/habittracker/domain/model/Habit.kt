package vn.kietnguyendev.habittracker.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Habit(
    val id: Long,
    val name: String,
    val description: String? = null,
    val startDate: Long,
    val endDate: Long? = null,
    val frequency: String,
    val reminderTime: Long? = null,
    val steak: Long,
    val completedDates: List<Long> = emptyList(),
    val color: String,
    val icon: String
)