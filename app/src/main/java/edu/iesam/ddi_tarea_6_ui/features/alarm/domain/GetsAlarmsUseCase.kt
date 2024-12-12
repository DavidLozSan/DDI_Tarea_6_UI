package edu.iesam.ddi_tarea_6_ui.features.alarm.domain

class GetsAlarmsUseCase(private val alarmRepository: AlarmRepository) {
    fun invoke() = alarmRepository.getAlarms()
}