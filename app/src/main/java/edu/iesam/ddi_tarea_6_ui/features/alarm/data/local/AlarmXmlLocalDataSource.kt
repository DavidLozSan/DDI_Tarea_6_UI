package edu.iesam.ddi_tarea_6_ui.features.alarm.data.local

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.iesam.ddi_tarea_6_ui.R
import edu.iesam.ddi_tarea_6_ui.features.alarm.domain.Alarm

class AlarmXmlLocalDataSource(private val context: Context) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_xml),
        Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun getAlarms(): List<Alarm> {
        val alarmJson = sharedPref.getString("alarms", null)
        return if (alarmJson.isNullOrEmpty()) {
            // Agregar alarmas predeterminadas al archivo de preferencias
            val defaultAlarms = listOf(
                Alarm(id = "1", title = "7:30", description = "Sonar una vez | Alarma despertador",false),
                Alarm(id = "2", title = "9:00", description = "Sonar una vez | Reunión de trabajo", false),
                Alarm(id = "3", title = "18:00", description = "Sonar una vez | Clase de yoga", false),
                Alarm(id = "4", title = "20:00", description = "Sonar una vez | Medicamentos", false),
                Alarm(id = "5", title = "10:00", description = "Sonar una vez | Cumpleaños de Ana", false),
                Alarm(id = "6", title = "18:00", description = "Sonar una vez | Clase de yoga", false),
                Alarm(id = "7", title = "20:00", description = "Sonar una vez | Medicamentos", false),
                Alarm(id = "8", title = "10:00", description = "Sonar una vez | Cumpleaños de Ana", false),
                Alarm(id = "9", title = "18:00", description = "Sonar una vez | Clase de yoga",false),
                Alarm(id = "10", title = "20:00", description = "Sonar una vez | Medicamentos", false),
                Alarm(id = "11", title = "10:00", description = "Sonar una vez | Cumpleaños de Ana", false),
            )
            saveDefaultAlarms(defaultAlarms)
            defaultAlarms
        } else {
            val type = object : TypeToken<List<Alarm>>() {}.type
            gson.fromJson(alarmJson, type) ?: emptyList()
        }
    }

    private fun saveDefaultAlarms(defaultAlarms: List<Alarm>) {
        val alarmJson = gson.toJson(defaultAlarms)
        sharedPref.edit().putString("alarms", alarmJson).apply()
    }

    fun addAlarm(alarm: Alarm) {
        val alarmJson = gson.toJson(alarm)
        sharedPref.edit().putString("alarms", alarmJson).apply()
    }
}