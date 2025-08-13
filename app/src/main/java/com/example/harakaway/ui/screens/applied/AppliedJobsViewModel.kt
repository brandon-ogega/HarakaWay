package com.example.harakaway.ui.screens.applied

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harakaway.data.models.Job
import com.example.harakaway.data.repository.JobsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppliedJobsViewModel: ViewModel(){
    val JobsRepository = JobsRepository()

    private val _jobs = MutableStateFlow<List<Job>>(emptyList())
    val jobs: StateFlow<List<Job>> get()  = _jobs

    init {
        getJobs()
    }

    fun getJobs(){
        viewModelScope.launch {
            _jobs.value = JobsRepository.getAllJobs()
        }
    }
}