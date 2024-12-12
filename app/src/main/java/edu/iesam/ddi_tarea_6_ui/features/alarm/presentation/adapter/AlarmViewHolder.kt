package edu.iesam.ddi_tarea_6_ui.features.alarm.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.ddi_tarea_6_ui.databinding.ViewAlarmItemBinding
import edu.iesam.ddi_tarea_6_ui.features.alarm.domain.Alarm

class AlarmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ViewAlarmItemBinding.bind(itemView) // Binding directo

    fun bind(alarm: Alarm) {
        binding.apply {
            alarmTitle.text = alarm.title
            alarmDescription.text = alarm.description
            alarmToggle.isChecked = false // Puedes personalizar el estado predeterminado
            alarmToggle.setOnCheckedChangeListener { _, isChecked ->
                // Maneja la lógica al alternar el switch
                // Por ejemplo: alarm.isActive = isChecked
            }
        }
    }
}