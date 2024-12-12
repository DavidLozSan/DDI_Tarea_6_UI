package edu.iesam.ddi_tarea_6_ui.features.alarm.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.ddi_tarea_6_ui.databinding.ActivityMainBinding
import edu.iesam.ddi_tarea_6_ui.features.alarm.domain.Alarm
import edu.iesam.ddi_tarea_6_ui.features.alarm.presentation.adapter.AlarmAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var alarmFactory: AlarmFactory
    private lateinit var viewModel: MainActivityViewModel
    private val alarmAdapter = AlarmAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        alarmFactory = AlarmFactory(this)
        viewModel = alarmFactory.buildMainActivityViewModel()
        setupObserver()
        viewModel.loadAlarms()
    }

    private fun setupView() {
        binding.apply {
            alarmRecyclerView.layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            alarmRecyclerView.adapter = alarmAdapter
        }
    }

    private fun setupObserver() {
        val nameObserver = Observer<MainActivityViewModel.UiState> { uiState ->
            uiState.alarms?.let { alarms ->
                bind(alarms)
            }
        }
        viewModel.uiState.observe(this@MainActivity, nameObserver)
    }

    private fun bind(alarms: List<Alarm>) {
        alarmAdapter.submitList(alarms)
    }
}