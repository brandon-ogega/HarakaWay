package com.example.harakaway.data.repository

import com.example.harakaway.data.models.Job
import kotlinx.coroutines.flow.Flow

interface JobsService {
    suspend fun createJob(job: Job): Job?
    suspend fun getAllJobs(): List<Job>
    suspend fun getJob(id: Int): Job?
    suspend fun updateJob(job: Job): Job?
    suspend fun insertImage(fileName: String,fileBytes: ByteArray): Flow<UploadResult>
    suspend fun deletePlace(id: Int): Boolean
}