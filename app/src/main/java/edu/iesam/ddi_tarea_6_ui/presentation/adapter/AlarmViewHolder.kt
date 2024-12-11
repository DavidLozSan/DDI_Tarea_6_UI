package edu.iesam.ddi_tarea_6_ui.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.ddi_tarea_6_ui.databinding.ViewAlarmItemBinding
import edu.iesam.ddi_tarea_6_ui.domain.Alarm

class AlarmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var binding: ViewAlarmItemBinding

    fun bind(alarm: Alarm) {
        binding = ViewAlarmItemBinding.bind(itemView)

        binding.apply {
            alarmTitle.text = alarm.title
            alarmDescription.text = alarm.description
        }
    }
}