package com.example.harakaway.data.repository

import com.example.harakaway.data.models.Job
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.UploadStatus
import io.github.jan.supabase.storage.storage
import io.github.jan.supabase.storage.uploadAsFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

sealed class UploadResult {
    data class Progress(val percent : Float): UploadResult()
    data class Success(val url: String): UploadResult()
}

class JobsRepository : JobsService{
    val supabase = createSupabaseClient(
        supabaseUrl = "https://cushzmijoeusbglcmwbz.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImN1c2h6bWlqb2V1c2JnbGNtd2J6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTQ2NTU1NjMsImV4cCI6MjA3MDIzMTU2M30.DLFrj2Lbp8gemwKFugKvQu86k0wNgUffcm8B6ev8Fnk"
    ) {
        install(Auth)
        install(Postgrest)
        install(Storage)
    }
    override suspend fun createJob(job: Job): Job? {
       val result = supabase.from("job").insert(job){
           select()
       }.decodeSingle<Job>()
        return result
    }

    override suspend fun getAllJobs(): List<Job> {
        val job = supabase.from("job").select().decodeList<Job>()
        return job
    }

    override suspend fun getJob(id: Int): Job?{
        val job = supabase.from("job").select {
            filter {
                Job::id eq id
            }
        }.decodeAsOrNull<Job>()
        return job
    }

    override suspend fun updateJob(job: Job): Job? {
     val job = supabase.from("job").update(
         job
     ) {
         select()
         filter {
          eq("id",job.id!!)
         }
     }.decodeSingle<Job>()
        return job
    }

    override suspend fun insertImage(
        fileName: String,
        fileBytes: ByteArray
    ): Flow<UploadResult>{
        val bucket = supabase.storage.from("job/images")
        return bucket.uploadAsFlow(fileName,fileBytes)
            .map { status ->
                when (status){
                    is UploadStatus.Progress ->{
                        val percent = status.totalBytesSend.toFloat() / status.contentLength *100
                        UploadResult.Progress(percent)
                    }
                    is UploadStatus.Success -> {
                        println("Upload succesful!")
                        UploadResult.Success(bucket.publicUrl(fileName))
                    }
                }
            }
    }

    override suspend fun deletePlace(id: Int): Boolean {
        supabase.from("job").delete {
            filter {
                eq("id", id)
            }
        }
        return getJob(id) == null
    }

}