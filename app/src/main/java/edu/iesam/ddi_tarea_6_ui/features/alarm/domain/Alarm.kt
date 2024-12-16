package edu.iesam.ddi_tarea_6_ui.features.alarm.domain

data class Alarm(
    val id: String,
    val title: String,
    val timeItSounds: String,
    val description: String,
    var toggle: Boolean
)