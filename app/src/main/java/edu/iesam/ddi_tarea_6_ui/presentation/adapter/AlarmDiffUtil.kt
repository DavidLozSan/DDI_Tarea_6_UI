package edu.iesam.ddi_tarea_6_ui.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import edu.iesam.ddi_tarea_6_ui.domain.Alarm

class AlarmDiffUtil : DiffUtil.ItemCallback<Alarm>() {
    override fun areItemsTheSame(oldItem: Alarm, newItem: Alarm): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Alarm, newItem: Alarm): Boolean {
        return oldItem == newItem
    }
}