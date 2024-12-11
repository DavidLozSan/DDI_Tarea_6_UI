package edu.iesam.ddi_tarea_6_ui.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.ddi_tarea_6_ui.R
import edu.iesam.ddi_tarea_6_ui.domain.Alarm

class AlarmAdapter : ListAdapter<Alarm, AlarmViewHolder>(AlarmDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.view_alarm_item, parent, false
        )
        return AlarmViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount(): Int = currentList.size
}