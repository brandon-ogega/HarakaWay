package com.example.harakaway.ui.screens.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harakaway.data.models.Job
import com.example.harakaway.data.repository.JobsRepository
import com.example.harakaway.data.repository.UploadResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AdminViewModel: ViewModel(){
    val jobsRepository = JobsRepository()

    private val _uploadProgress = MutableStateFlow<Float>(0f)
    val uploadProgress: StateFlow<Float> get() = _uploadProgress

    private val _job : MutableStateFlow<Job> = MutableStateFlow(Job(
        image_url = "",
        companyName = "",
        title = "",
        jobCategory = "",
        salary = "",
        location = "",
        status = "",
    ))

    val job: StateFlow<Job> get() = _job
    fun createJob(companyName: String, title: String,jobCategory: String,salary: String,location: String,status: String) {
        viewModelScope.launch {
            _job.value = _job.value.copy(
                companyName = companyName
                , title = title
                , jobCategory = jobCategory,
                salary = salary,
                location = location,
                status = status
                )
            jobsRepository.createJob(_job.value)
        }
    }
    fun insertImage(fileName: String, fileBytes: ByteArray) {
        viewModelScope.launch {
            jobsRepository.insertImage(fileName, fileBytes).collect { result ->
                when (result) {
                    is UploadResult.Progress -> {
                        _uploadProgress.value = result.percent
                    }
                    is UploadResult.Success -> {
                        _job.value = _job.value.copy(image_url = result.url)
                    }
                }

            }
        }
    }
}