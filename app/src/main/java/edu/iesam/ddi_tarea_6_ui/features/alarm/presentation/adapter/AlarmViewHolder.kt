package edu.iesam.ddi_tarea_6_ui.features.alarm.presentation.adapter

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.ddi_tarea_6_ui.R
import edu.iesam.ddi_tarea_6_ui.databinding.ViewAlarmItemBinding
import edu.iesam.ddi_tarea_6_ui.features.alarm.domain.Alarm

class AlarmViewHolder(itemView: View, private val context: Context) :
    RecyclerView.ViewHolder(itemView) {

    private val binding = ViewAlarmItemBinding.bind(itemView)
    fun bind(alarm: Alarm) {
        binding.apply {
            alarmTitle.text = alarm.title
            alarmDescription.text = alarm.description
            alarmTimeItSounds.text = alarm.timeItSounds
            alarmToggle.isChecked = alarm.toggle
            if (alarmToggle.isChecked) {
                alarmTitle.setTextColor(ContextCompat.getColor(context, R.color.md_theme_onTertiaryContainer))
                alarmDescription.setTextColor(ContextCompat.getColor(context, R.color.md_theme_onTertiaryContainer))
                alarmTimeItSounds.setTextColor(ContextCompat.getColor(context, R.color.md_theme_onTertiaryContainer))
            } else {
                alarmTitle.setTextColor(ContextCompat.getColor(context, R.color.md_theme_grey))
                alarmDescription.setTextColor(ContextCompat.getColor(context, R.color.md_theme_grey))
                alarmTimeItSounds.setTextColor(ContextCompat.getColor(context, R.color.md_theme_grey))
            }

            alarmToggle.setOnCheckedChangeListener(null) // Eliminar cualquier listener previo
            alarmToggle.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    alarm.toggle = true
                    Toast.makeText(context, "Alarma \"${alarm.description}\" activada", Toast.LENGTH_SHORT)
                        .show()
                    alarmTitle.setTextColor(ContextCompat.getColor(context, R.color.md_theme_onTertiaryContainer))
                    alarmDescription.setTextColor(ContextCompat.getColor(context, R.color.md_theme_onTertiaryContainer))
                    alarmTimeItSounds.setTextColor(ContextCompat.getColor(context, R.color.md_theme_onTertiaryContainer))
                } else {
                    alarm.toggle = false
                    Toast.makeText(context, "Alarma \"${alarm.description}\" desactivada", Toast.LENGTH_SHORT)
                        .show()
                    alarmTitle.setTextColor(ContextCompat.getColor(context, R.color.md_theme_grey))
                    alarmDescription.setTextColor(ContextCompat.getColor(context, R.color.md_theme_grey))
                    alarmTimeItSounds.setTextColor(ContextCompat.getColor(context, R.color.md_theme_grey))
                }
            }

        }
    }
}