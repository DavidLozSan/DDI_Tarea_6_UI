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
            val defaultAlarms = listOf(
                Alarm(id = "1", title = "07:30", "Sonar una vez |","Despertador diario", true),
                Alarm(id = "2", title = "08:00", "Sonar una vez |" ,"Preparar desayuno", false),
                Alarm(id = "3", title = "09:00", "Sonar una vez |", "Reunión de trabajo", true),
                Alarm(id = "4", title = "12:00", "Sonar una vez |","Llamada con cliente", true),
                Alarm(id = "5", title = "15:30", "Sonar una vez |", "Recoger a los niños", false),
                Alarm(id = "6", title = "17:00", "Sonar una vez |", "Cita con el dentista", false),
                Alarm(id = "7", title = "18:00", "Sonar una vez |", "Clase de yoga", true),
                Alarm(id = "8", title = "19:00", "Sonar una vez |", "Ir al supermercado", false),
                Alarm(id = "9", title = "20:00", "Sonar una vez |", "Tomar medicamentos", false),
                Alarm(id = "10", title = "21:30","Sonar una vez |", "Leer un libro", true),
                Alarm(id = "11", title = "23:00","Sonar una vez |", "Ir a la cama", true)
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