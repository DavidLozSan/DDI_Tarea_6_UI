package edu.iesam.ddi_tarea_6_ui.features.alarm.presentation

import android.content.Context
import edu.iesam.ddi_tarea_6_ui.features.alarm.data.AlarmDataRepository
import edu.iesam.ddi_tarea_6_ui.features.alarm.data.local.AlarmXmlLocalDataSource
import edu.iesam.ddi_tarea_6_ui.features.alarm.domain.AddAlarmUseCase
import edu.iesam.ddi_tarea_6_ui.features.alarm.domain.GetsAlarmsUseCase


class AlarmFactory(private val context: Context) {
    private val alarmLocal = AlarmXmlLocalDataSource(context)
    private val alarmDataRepository = AlarmDataRepository(alarmLocal)
    private val getsAlarmsUseCase = GetsAlarmsUseCase(alarmDataRepository)
    private val addAlarmUseCase = AddAlarmUseCase(alarmDataRepository)

    fun buildMainActivityViewModel() = MainActivityViewModel(getsAlarmsUseCase)
}