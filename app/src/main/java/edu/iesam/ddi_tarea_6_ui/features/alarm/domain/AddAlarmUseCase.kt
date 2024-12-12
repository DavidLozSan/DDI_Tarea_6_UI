package edu.iesam.ddi_tarea_6_ui.features.alarm.domain

class AddAlarmUseCase(private val alarmRepository: AlarmRepository) {
    fun invoke(alarm: Alarm) = alarmRepository.addAlarm(alarm)
}