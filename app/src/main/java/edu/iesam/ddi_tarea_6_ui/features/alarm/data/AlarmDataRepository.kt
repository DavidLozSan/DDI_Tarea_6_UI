package edu.iesam.ddi_tarea_6_ui.features.alarm.data

import edu.iesam.ddi_tarea_6_ui.features.alarm.data.local.AlarmXmlLocalDataSource
import edu.iesam.ddi_tarea_6_ui.features.alarm.domain.Alarm
import edu.iesam.ddi_tarea_6_ui.features.alarm.domain.AlarmRepository

class AlarmDataRepository(private val local: AlarmXmlLocalDataSource) : AlarmRepository {

    override fun getAlarms(): List<Alarm> = local.getAlarms()

    override fun addAlarm(alarm: Alarm) {
        local.addAlarm(alarm)
    }
}