package edu.iesam.ddi_tarea_6_ui.features.alarm.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.iesam.ddi_tarea_6_ui.features.alarm.domain.Alarm
import edu.iesam.ddi_tarea_6_ui.features.alarm.domain.GetsAlarmsUseCase

class MainActivityViewModel(private val getsAlarmsUseCase: GetsAlarmsUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadAlarms() {
        val result = getsAlarmsUseCase.invoke()
        _uiState.postValue(
            UiState(
                alarms = result
            )
        )
    }

    data class UiState(
        val alarms: List<Alarm>? = null
    )
}