package edu.iesam.ddi_tarea_6_ui.features.alarm.domain

interface AlarmRepository {
    fun getAlarms(): List<Alarm>
    fun addAlarm(alarm: Alarm)
}